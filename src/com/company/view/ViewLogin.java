package com.company.view;

import com.company.controller.ControllCar;
import com.company.controller.ControllPerson;
import com.company.controller.ControllRentCar;
import com.company.model.person.Customer;
import com.company.model.person.Person;
import com.company.model.person.Staff;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class ViewLogin  {

    private Scanner read ;
    private ControllPerson controllPerson;

    public ViewLogin(){

        read = new Scanner(System.in);
        controllPerson = new ControllPerson();
    }

    public void menu(){

        System.out.println("Exit : press 1");
        System.out.println("Log In : press 2");
        System.out.println("Register, new account : press 3");
    }

    public void play(){

        boolean run = true;
        int choice;

        while (run){

           menu();
           System.out.println("\nChoice : ");
           choice = Integer.parseInt(read.nextLine());

           switch (choice){

               case 1 : run = false;
               break;

               case 2 : logIn();
               break;

               case 3 : register();
               break;
           }
        }

    }

    public void logIn(){

        System.out.println("Name : ");
        String name = read.nextLine();

        System.out.println("Password : ");
        String password = read.nextLine();

        Person p = controllPerson.getPersonByNameAndPassword(name, password);

        if(p!=null){
             if(p instanceof Customer){

                  new ViewCustomer((Customer) p, controllPerson).play();
             }
             else if (p instanceof Staff){

                 new ViewStaff((Staff) p, controllPerson).play();
             }
        }
        else{
            System.out.println("Name or password incorrect !!!");
        }
    }

    public void register(){

        System.out.println("Name : ");
        String name = read.nextLine();

        while(controllPerson.existsName(name)){

            System.out.println("This name is already taken, try another one");
            System.out.println("Name : ");
            name = read.nextLine();
        }

        System.out.println("Password : ");
        String password = read.nextLine();

        System.out.println("Age : ");
        int age = Integer.parseInt(read.nextLine());

        System.out.println("Height : ");
        double height = Double.parseDouble(read.nextLine());

        System.out.println("Address : ");
        String address = read.nextLine();

        System.out.println("Phone : ");
        String phone = read.nextLine();

        Customer c = new Customer(controllPerson.getNextAvailableID(), name, age, height, "Customer", password, address, phone);

        controllPerson.add(c);
        controllPerson.saveToFile();
        System.out.println("You just registered :)");
    }



}
