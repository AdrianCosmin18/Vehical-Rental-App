//package com.company.view;
//
//import com.company.controller.ControllPerson;
//import com.company.model.person.Customer;
//import com.company.model.person.Person;
//
//import java.util.Scanner;
//
//public class ViewRegister {
//
//    private Scanner read;
//    private ControllPerson controllPerson;
//    private ViewLogin viewLogin;
//
//    public ViewRegister(){
//
//        read = new Scanner(System.in);
//        controllPerson = new ControllPerson();
//        viewLogin = new ViewLogin();
//    }
//
//    public void menu(){
//
//        System.out.println("Log In : press 1");
//        System.out.println("Register, new account : press 2");
//        System.out.println("Exit : press 3");
//    }
//
//    public void play(){
//
//        boolean run = true;
//        int choice;
//
//        while(run){
//
//            menu();
//            System.out.println("\nChoice : ");
//            choice = Integer.parseInt(read.nextLine());
//
//            switch(choice){
//
//                case 1 : viewLogin.logIn();
//                break;
//
//                case 2 : register();
//                break;
//
//                case 3 : run = false;
//                break;
//            }
//        }
//    }
//    //register only as customer is possible
//    public void register(){
//
//        System.out.println("Name : ");
//        String name = read.nextLine();
//
//        if(controllPerson.existsName(name)){
//
//            do {
//                System.out.println("There is already a user with this name, try another name");
//                System.out.println("Name : ");
//                name = read.nextLine();
//            }
//            while(controllPerson.existsName(name));
//        }
//
//
//        System.out.println("Password : ");
//        String password = read.nextLine();
//
//        System.out.println("Age : ");
//        int age = Integer.parseInt(read.nextLine());
//
//        System.out.println("Height : ");
//        double height = Double.parseDouble(read.nextLine());
//
//        System.out.println("Address : ");
//        String address = read.nextLine();
//
//        System.out.println("Phone : ");
//        String phone = read.nextLine();
//
//        controllPerson.add(new Customer(controllPerson.getNextAvailableID(), name, age, height, "Customer", address, phone, password));
//
//        controllPerson.saveToFile();
//
//        System.out.println("Acount successfully created");
//
//    }
//}
