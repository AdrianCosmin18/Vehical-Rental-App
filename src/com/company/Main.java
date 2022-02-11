package com.company;
import com.company.controller.ControllCar;
import com.company.controller.ControllPerson;
import com.company.controller.ControllRentCar;
import com.company.model.person.Customer;
import com.company.model.person.Staff;
import com.company.model.rentCar.RentCar;
import com.company.view.View;
import com.company.view.ViewCustomer;
import com.company.view.ViewLogin;
import com.company.view.ViewStaff;
import jdk.swing.interop.SwingInterOpUtils;

import javax.naming.ldap.Control;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Staff cosmin = new Staff("0,Cosmin,22,1.77,Staff,IT,2000.0,decembrie");
        Customer mihai = new Customer("1,Mihai,32,1.8,Customer,Timisul de Jos,0734506798,ianuarie");
        ViewStaff v = new ViewStaff(cosmin);
        //v.play();

        ViewLogin logIn = new ViewLogin();
        logIn.play();



    }
}
