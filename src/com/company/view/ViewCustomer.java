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

    public ViewCustomer(Customer customer){

        cin = new Scanner(System.in);
        controllCar = new ControllCar();
        controllPerson = new ControllPerson();
        controllRentCar = new ControllRentCar();
        this.customer = customer;
    }

    public void menu(){

        System.out.println("Customer : " + customer.getName());
        System.out.println("======================================");
        System.out.println("Exit : press 0");
        System.out.println();
        System.out.println("List of current vehicles : press 1");
        System.out.println("Rent a car : press 2");
        System.out.println("History of my rents : press 3");
        System.out.println("Modify the return date of the car : press 4");
        System.out.println("Get rent information by fromDate or toDate : press 5");
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

                case 1 : controllCar.traverse();
                    break;

                case 2 : rentCar();
                    break;

                case 3 : history();
                    break;

            }
        }
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
}
