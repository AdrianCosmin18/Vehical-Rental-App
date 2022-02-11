package com.company.controller;

import com.company.model.Customer;
import com.company.model.Person;
import com.company.model.RentCar;
import com.company.model.Staff;

import javax.naming.ldap.Control;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllRentCar {

    private ArrayList<RentCar> rents;

    public ControllRentCar(){

        rents = new ArrayList<RentCar>();
        load();
    }

    void load() {

        File f = new File("com/company/resources/rentCars.txt");
        Scanner cin = new Scanner(f);
        while(cin.hasNextLine()){

            String text = cin.nextLine();
            rents.add(new RentCar(text));
        }
    }
}
