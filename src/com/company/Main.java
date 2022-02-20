package com.company;
import com.company.controller.ControllCar;
import com.company.controller.ControllPerson;
import com.company.controller.ControllRentCar;
import com.company.model.person.Customer;
import com.company.model.person.Person;
import com.company.model.person.Staff;
import com.company.model.rentCar.RentCar;
import com.company.view.*;
import jdk.swing.interop.SwingInterOpUtils;

import javax.naming.ldap.Control;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ViewLogin viewLogin = new ViewLogin();
        viewLogin.play();


    }
}
