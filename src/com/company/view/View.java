package com.company.view;

import com.company.controller.ControllCar;
import com.company.controller.ControllPerson;
import com.company.model.Car;
import com.company.model.Customer;
import com.company.model.Person;
import com.company.model.Staff;
import org.w3c.dom.ls.LSInput;

import java.awt.*;
import java.util.Scanner;

public class View {


    private Scanner citeste;

    private ControllCar controllCar;
    private ControllPerson cp;


    public View(){

        citeste = new Scanner(System.in);

        controllCar = new ControllCar();
        cp = new ControllPerson();
    }

    void menu(){

        System.out.println("======================================");
        System.out.println("Exit : press 0");
        System.out.println("\nView Car : ");
        System.out.println();
        System.out.println("List of current cars : press 1");
        System.out.println("Add a car :  press 2");
        System.out.println("Remove a car : press 3");

        System.out.println("\nView Person : ");
        System.out.println();
        System.out.println("List of the current persons : press 11");
        System.out.println("Add a person : press 12");
        System.out.println("Remove a person : press 13");
        System.out.println("Modify a persin : press 14");
        System.out.println("======================================");

    }


    public void play(){

        boolean running=true;

        int alegere;
        while (running){

            menu();
            System.out.print("Choice : ");
            alegere=Integer.parseInt(citeste.nextLine());

            switch (alegere){
                case 0:running = false;

                case 1:controllCar.traverse();
                break;

                case 2:addCar();
                break;

                case 3:removeCar();
                break;

                case 11:cp.traverse();
                break;

                case 12:addPerson();
                break;

                case 13:removePerson();
                break;

                case 14:modifyPerson();
                break;
            }



        }
    }

    public void addCar(){

        System.out.println("Brand of the new car : ");
        String brand = citeste.nextLine();

        System.out.println("Model of the new car : ");
        String model = citeste.nextLine();

        System.out.println("Year of the new car : ");
        int year = Integer.parseInt(citeste.nextLine());

        if(controllCar.getIdByBrandAndModel(brand, model) == -1){

            Car c = new Car(controllCar.getNextAvailableID(),brand, model, year);
            controllCar.add(c);
        }
        else{
            System.out.println("Already exists a car with this brand and model");
        }
    }

    public void removeCar(){

        System.out.println("Car's brand you want to erase : ");
        String brand = citeste.nextLine();

        System.out.println("Car's model you want to erase : ");
        String model = citeste.nextLine();

        Car c = controllCar.getCarById(controllCar.getIdByBrandAndModel(brand, model));

        if(c.getId() != -1){

            controllCar.remove(c);
            System.out.println("Remove succes !");
        }
        else{
            System.out.println("This car cant be remove cause it doesnt exists");
        }
    }

    public void addPerson(){

        System.out.println("\nType of the new Person you want to add: ");
        System.out.println("1 - Staff; 2 - Customer");
        int choice = Integer.parseInt(citeste.nextLine());

        System.out.println("Name : ");
        String name = citeste.nextLine();

        System.out.println("Age : ");
        int age = Integer.parseInt(citeste.nextLine());

        System.out.println("Height : ");
        double height = Double.parseDouble(citeste.nextLine());


        if(choice == 1){

            System.out.println("Department : ");
            String dept = citeste.nextLine();

            System.out.println("Salary : ");
            double salary = Double.parseDouble(citeste.nextLine());

            Staff st = new Staff(cp.getNextAvailableID(), name, age, height, "Staff", dept, salary);
            cp.add(st);
            cp.saveToFile();
        }
        if(choice == 2){

            System.out.println("Address : ");
            String address = citeste.nextLine();

            System.out.println("Phone : ");
            String phone = citeste.nextLine();

            Customer c = new Customer(cp.getNextAvailableID(), name, age, height, "Customer", address, phone);
            cp.add(c);
            cp.saveToFile();
        }
    }

    public void removePerson(){

        System.out.println("Person's ID you want to erase : ");
        int id = Integer.parseInt(citeste.nextLine());

        cp.remove(cp.getPersonById(id));
    }

    public void modifyPerson(){

        System.out.println("Person's ID you want to modify : ");
        int id = Integer.parseInt(citeste.nextLine());

        System.out.println("Name : ");
        String name = citeste.nextLine();

        System.out.println("Age : ");
        int age = Integer.parseInt(citeste.nextLine());

        System.out.println("Height : ");
        double height = Double.parseDouble(citeste.nextLine());

        Person p = new Person();
        p = cp.getPersonById(id);

        if(p.getType() == "Staff"){

            System.out.println("Department : ");
            String dept = citeste.nextLine();

            System.out.println("Salary : ");
            double salary = Double.parseDouble(citeste.nextLine());

            cp.modify_staff(id, name, age, height, dept, salary);
        }
        else if (p.getType() == "Customer"){

            System.out.println("Address : ");
            String address = citeste.nextLine();

            System.out.println("Phone : ");
            String phone = citeste.nextLine();

            cp.modify_customer(id, name, age, height, address, phone);
        }
    }
}
