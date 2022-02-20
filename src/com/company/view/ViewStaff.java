package com.company.view;

import com.company.controller.ControllCar;
import com.company.controller.ControllPerson;
import com.company.controller.ControllRentCar;
import com.company.model.car.Buss;
import com.company.model.car.Car;
import com.company.model.person.Customer;
import com.company.model.person.Person;
import com.company.model.person.Staff;
import com.company.model.rentCar.RentCar;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewStaff {

    private Scanner cin;
    private ControllRentCar controllRentCar;
    private ControllPerson controllPerson;
    private ControllCar controllCar;

    private Staff staff;

    //obs: trimitem si controllerul ca parametru pt ca altfel se va lucra pe 2 ControllPerson diferite (cel din ViewLogIns si cel de aici din ViewStaff
    public ViewStaff(Staff staff, ControllPerson cp){

        cin = new Scanner(System.in);
        controllRentCar = new ControllRentCar();
        controllCar = new ControllCar();
        controllPerson = cp;
        this.staff = staff;
    }

    public void menu(){

        System.out.println("\nStaff : " + staff.getName());
        System.out.println("======================================");
        System.out.println("Log out : press 0");
        System.out.println("Change password : press 100");
        System.out.println("Change name : press 101");
        System.out.println();
        System.out.println("List of current vehicles : press 1");
        System.out.println("Rent a car : press 2");
        System.out.println("History of my rents : press 3");
        System.out.println("Modify the return date of the car : press 4");
        System.out.println();
        System.out.println("Add a vehicle :  press 7");
        System.out.println("Remove a vehicle : press 8");
        System.out.println("Modify a vehicle : press 9");
        System.out.println();
        System.out.println("List of the current persons : press 11");
        System.out.println("Add a person : press 12");
        System.out.println("Remove a person : press 13");
        System.out.println("Modify a person : press 14");
        System.out.println("======================================");
        System.out.println();
    }

    public void play(){

        boolean run = true;
        int choice;

        while(run){

            menu();
            System.out.println("\nChoice : ");
            choice = Integer.parseInt(cin.nextLine());

            switch (choice){

                case 0 : run = false;
                break;

                case 100: newPassword();
                break;

                case 101: newName();
                break;

                case 1 : controllCar.traverse();
                break;

                case 2 : rentCar();
                break;

                case 3 : history();
                break;

                case 4 : modifyReturnDate();
                break;

                case 7 : addVehicle();
                break;

                case 8 : removeVehicle();
                break;

                case 9 : modifyVehicle();
                break;

                case 11 : controllPerson.traverse();
                break;

                case 12 : addPerson();
                break;

                case 13 : removePerson();
                break;

                case 14 : modifyPerson();
                break;
            }
        }
    }


    public void newPassword(){

        System.out.println("Old password : ");
        String oldPassword = cin.nextLine();

        if(staff.getPassword().equals(oldPassword)){

            System.out.println("New password : ");
            String newPassword = cin.nextLine();
            staff.setPassword(newPassword);
            System.out.println("The password was modified");


            controllPerson.saveToFile();
        }
        else{

            System.out.println("Incorrect password !!!");
        }
    }

    public void newName(){

        System.out.println("The new name : ");
        String newName = cin.nextLine();

        while(controllPerson.existsName(newName)){

            System.out.println("This name is already taken, try another one");
            System.out.println("The new name : ");
            newName = cin.nextLine();
        }

        staff.setName(newName);
        controllPerson.saveToFile();
        System.out.println("The name was modified");
    }


    public void rentCar(){

        System.out.println("Car's ID you want to rent : ");
        int carId = Integer.parseInt(cin.nextLine());

        if(controllCar.existsId(carId)){

            System.out.println("Insert the start date you want the car : ");
            System.out.println("The type of the insert is : YYYY-MM-DD " + " , exemple : 2034-01-04");
            String fromDate = cin.nextLine();

            System.out.println("Insert the car's return date : ");
            System.out.println("The type of the insert is : YYYY-MM-DD " + " , exemple : 2034-01-04");
            String toDate = cin.nextLine();

            controllRentCar.add(new RentCar(controllRentCar.getNextAvailableID(), staff.getId(), carId, fromDate, toDate));
            controllRentCar.saveToFile();
        }
        else{

            System.out.println("It doesn't exist a car with this id");
        }
    }

    public void history(){

        String text = "";
        ArrayList<RentCar> list = controllRentCar.getListByPersonId(staff.getId());
        int count = 0;
        for(RentCar r : list){
            count++;
            text += "\n\nRent : " + count + "\n";
            text += "\nFrom Date : " + r.getFromDate();
            text += "\nTo Date : " + r.getToDate();
            text += "\nCar's brand and model : " + controllCar.getCarById(r.getIdCar()).getBrand() + " " + controllCar.getCarById(r.getIdCar()).getModel();

        }

        System.out.println(text);
    }

    public void modifyReturnDate(){

        System.out.println("Insert the date you rented the car : ");
        System.out.println("The type of the insert is : YYYY-MM-DD " + " , exemple : 2034-01-04");
        String fromDate = cin.nextLine();

        System.out.println("Insert the new date you want to return the car : ");
        System.out.println("The type of the insert is : YYYY-MM-DD " + " , exemple : 2034-01-04");
        String toDate = cin.nextLine();

        ArrayList<RentCar> list = controllRentCar.getListByPersonId(staff.getId());
        for(RentCar r : list){

            if(r.getFromDate().equals(fromDate)){

                r.setToDate(toDate);
                System.out.println("Modify Done");
            }
        }
    }


    public void addVehicle(){

        System.out.println("New Car");
        System.out.println("Insert the brand : ");
        String brand = cin.nextLine();
        System.out.println("Insert the model : ");
        String model = cin.nextLine();
        System.out.println("Insert the year : ");
        int year = Integer.parseInt(cin.nextLine());
        System.out.println("Car : press 1");
        System.out.println("Buss : press 2");
        int var = Integer.parseInt(cin.nextLine());

        if(var == 1){

            if(controllCar.getIdByBrandAndModel(brand, model) == -1){

                controllCar.add(new Car(controllCar.getNextAvailableID(), brand, model, year, "Car"));
                System.out.println("Car added with succes");
                controllCar.saveToFile();
            }
            else{

                System.out.println("Already exists a car with this brand and model");
            }
        }
        else if (var == 2){

            if (controllCar.getIdByBrandAndModel(brand, model) == -1){

                System.out.println("Insert the capacity of the buss : ");
                int capacity = Integer.parseInt(cin.nextLine());

                System.out.println("Insert the length of the buss : ");
                double length = Double.parseDouble(cin.nextLine());

                controllCar.add(new Buss(controllCar.getNextAvailableID(), brand, model, year, "Buss", capacity, length));
                System.out.println("Buss added with succes");
                controllCar.saveToFile();
            }
            else{

                System.out.println("Already exists a buss with this brand and model");
            }
        }
    }

    public void removeVehicle(){

        System.out.println("Car's brand you want to erase : ");
        String brand = cin.nextLine();

        System.out.println("Car's model you want to erase : ");
        String model = cin.nextLine();

        Car c = controllCar.getCarById(controllCar.getIdByBrandAndModel(brand, model));

        if(c.getId() != -1){

            controllCar.remove(c);
            System.out.println("Remove succes !");
            controllCar.saveToFile();
        }
        else{
            System.out.println("This car cant be remove cause it doesnt exists");
        }
    }

    public void modifyVehicle(){

        System.out.println("Car's brand you want to modify : ");
        String oldBrand = cin.nextLine();

        System.out.println("Car's model you want to modify : ");
        String oldModel = cin.nextLine();


        System.out.println("Vehicle's new brand : ");
        String brand = cin.nextLine();

        System.out.println("Vehicle's new model : ");
        String model = cin.nextLine();

        System.out.println("Vehicle's new year : ");
        int year = Integer.parseInt(cin.nextLine());

        Car c = new Car ();
        c = controllCar.getCarById(controllCar.getIdByBrandAndModel(oldBrand, oldModel));

        if(c.getId() != -1 && c.getType() == "Buss"){

            Buss b = (Buss) c;

            System.out.println("Buss's capacity you want to modify : ");
            int capacity = Integer.parseInt(cin.nextLine());

            System.out.println("Buss's length you want to modify : ");
            double length = Double.parseDouble(cin.nextLine());

            controllCar.modifyBuss(b.getId(), brand, model, year, capacity, length);

            controllCar.saveToFile();
        }
        else if(c.getId() != -1 && c.getType() == "Car"){

            controllCar.modifyCar(c.getId(), brand, model, year);

            controllCar.saveToFile();
        }
    }


    public void addPerson(){

        System.out.println("\nType of the new Person you want to add: ");
        System.out.println("1 - Staff; 2 - Customer");
        int choice = Integer.parseInt(cin.nextLine());

        System.out.println("Name : ");
        String name = cin.nextLine();

        System.out.println("Age : ");
        int age = Integer.parseInt(cin.nextLine());

        System.out.println("Height : ");
        double height = Double.parseDouble(cin.nextLine());

        System.out.println("Password : ");
        String pass = cin.nextLine();


        if(choice == 1){

            System.out.println("Department : ");
            String dept = cin.nextLine();

            System.out.println("Salary : ");
            double salary = Double.parseDouble(cin.nextLine());


            Staff st = new Staff(controllPerson.getNextAvailableID(), name, age, height, "Staff", pass, dept, salary);
            controllPerson.add(st);
            controllPerson.saveToFile();
        }
        if(choice == 2){

            System.out.println("Address : ");
            String address = cin.nextLine();

            System.out.println("Phone : ");
            String phone = cin.nextLine();


            Customer c = new Customer(controllPerson.getNextAvailableID(), name, age, height, "Customer", pass, address, phone);
            controllPerson.add(c);
            controllPerson.saveToFile();
        }
    }

    public void removePerson(){

        System.out.println("Person's ID you want to erase : ");
        int id = Integer.parseInt(cin.nextLine());

        controllPerson.remove(controllPerson.getPersonById(id));
    }

    public void modifyPerson(){

        System.out.println("Person's ID you want to modify : ");
        int id = Integer.parseInt(cin.nextLine());

        System.out.println("Name : ");
        String name = cin.nextLine();

        System.out.println("Age : ");
        int age = Integer.parseInt(cin.nextLine());

        System.out.println("Height : ");
        double height = Double.parseDouble(cin.nextLine());

        System.out.println("Password : ");
        String pass = cin.nextLine();

        Person p = new Person();
        p = controllPerson.getPersonById(id);

        if(p.getType() == "Staff"){

            System.out.println("Department : ");
            String dept = cin.nextLine();

            System.out.println("Salary : ");
            double salary = Double.parseDouble(cin.nextLine());


            controllPerson.modifyStaff(id, name, age, height, pass, dept, salary);

            controllPerson.saveToFile();
        }
        else if (p.getType() == "Customer"){

            System.out.println("Address : ");
            String address = cin.nextLine();

            System.out.println("Phone : ");
            String phone = cin.nextLine();


            controllPerson.modifyCustomer(id, name, age, height, pass, address, phone);

            controllPerson.saveToFile();
        }
    }
}
