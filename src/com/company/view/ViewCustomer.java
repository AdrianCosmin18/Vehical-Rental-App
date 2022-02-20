package com.company.view;

import com.company.controller.ControllCar;
import com.company.controller.ControllPerson;
import com.company.controller.ControllRentCar;
import com.company.model.car.Car;
import com.company.model.person.Customer;
import com.company.model.rentCar.RentCar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewCustomer {

    private Scanner cin;
    private ControllCar controllCar;
    private ControllPerson controllPerson;
    private ControllRentCar controllRentCar;

    private Customer customer;

    ////obs: trimitem si controllerul ca parametru pt ca altfel se va lucra pe 2 ControllPerson diferite (cel din ViewLogIn si cel de aici din ViewCustomer
    public ViewCustomer(Customer customer, ControllPerson cp){

        cin = new Scanner(System.in);
        controllCar = new ControllCar();
        controllPerson = cp;
        controllRentCar = new ControllRentCar();
        this.customer = customer;
    }

    public void menu(){

        System.out.println("\nCustomer : " + customer.getName());
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

                case 4 : modify();
                    break;
            }
        }
    }

    public void newPassword(){

        System.out.println("Old password : ");
        String oldPassword = cin.nextLine();

        if(customer.getPassword().equals(oldPassword)){

            System.out.println("New password : ");
            String newPassword = cin.nextLine();
            customer.setPassword(newPassword);
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

        customer.setName(newName);
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

            controllRentCar.add(new RentCar(controllRentCar.getNextAvailableID(), customer.getId(), carId, fromDate, toDate));
            controllRentCar.saveToFile();
        }
        else{

            System.out.println("It doesn't exist a car with this id");
        }
    }

    public void history(){

        String text = "";
        ArrayList<RentCar> list = controllRentCar.getListByPersonId(customer.getId());
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

    public void modify(){

        System.out.println("Insert the date you rented the car : ");
        System.out.println("The type of the insert is : YYYY-MM-DD " + " , exemple : 2034-01-04");
        String fromDate = cin.nextLine();

        System.out.println("Insert the new date you want to return the car : ");
        System.out.println("The type of the insert is : YYYY-MM-DD " + " , exemple : 2034-01-04");
        String toDate = cin.nextLine();

        ArrayList<RentCar> list = controllRentCar.getListByPersonId(customer.getId());
        for(RentCar r : list){

            if(r.getFromDate().equals(fromDate)){

                r.setToDate(toDate);
                System.out.println("Modify Done");
            }
        }
    }

}
