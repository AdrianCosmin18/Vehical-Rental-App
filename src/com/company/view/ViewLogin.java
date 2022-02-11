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
           }
        }


    }


    public void logIn(){

        System.out.println("Name : ");
        String name = read.nextLine();

        System.out.println("Password : ");
        String password = read.nextLine();

        Person p = controllPerson.getPersonByNameAndPassword(name, password);

        if(p.getId() != -1){

             if(p instanceof Customer){

                  new ViewCustomer((Customer) p).play();
             }
             else if (p instanceof Staff){

                 new ViewStaff((Staff) p).play();
             }
        }
        else{

            System.out.println("Name or password incorrect !!!");
        }
    }



}
