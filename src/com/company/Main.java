package com.company;
import com.company.controller.ControllCar;
import com.company.controller.ControllPerson;
import com.company.model.*;
import com.company.view.View;
import jdk.swing.interop.SwingInterOpUtils;

import javax.naming.ldap.Control;

public class Main {

    public static void main(String[] args) {

        //View v = new View();
        //v.play();

        RentCar rent1 = new RentCar("1,1,1,2021-01-04,2021-01-29");
        System.out.println(rent1.describe());
    }
}
