package com.company.controller;

import com.company.model.person.Customer;
import com.company.model.person.Person;
import com.company.model.person.Staff;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllPerson {

    private ArrayList<Person> persons;

    public ControllPerson(){

        this.persons= new ArrayList<>();
        this.load();
    }

    public void load(){

        try{

            File f = new File("src/com/company/resources/persons.txt");
            Scanner read = new Scanner(f);
            while(read.hasNextLine()){

                String text = read.nextLine();
                switch(text.split(",")[4]){

                    case "Staff":persons.add(new Staff(text));
                    break;

                    case "Customer" : persons.add(new Customer(text));
                    break;
                }
            }
        }catch (Exception e){}
    }

    public Person getPersonById(int id){

        for(Person p : persons){

            if(p.getId() == id) {

                return p;
            }
        }
        return null;
    }

    public void traverse(){

        for(Person p:persons){

            System.out.println(p.describe());

        }
    }

    public boolean existsId(int id){

        for(Person p : persons){

            if(p.getId() == id){

                return true;
            }
        }
        return false;
    }

    public void add(Person p){

        if(!existsId(p.getId())){

            persons.add(p);
        }
        else{
            System.out.println("Exista deja acest id");
        }
    }

    public int indexOf(Person pers){

        int index = -1;
        for(Person p : persons){

            index++;
            if(p.equals(pers)){

                return index;
            }
        }
        return -1;
    }

    public void remove(int index){

        persons.remove(index);
    }

    public void remove(Person p){

        persons.remove(indexOf(p));
    }

    public void saveToFile(){

        try{
            File f = new File("src/com/company/resources/persons.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(Person p: persons){

                pw.print(p.toString());
                pw.print("\n");
            }
            pw.close();

        }catch(Exception e){}
    }

    @Override
    public String toString(){
        String  text="";

        for(Person p:persons){
            text += p+"\n";
        }
        return text;
    }

    public int getNextAvailableID(){

        return persons.get(persons.size() - 1).getId() + 1;
    }

    public boolean existsID(int id){

        for(Person p:persons){

            if(p.getId() == id)
                return true;
        }

        return false;
    }

    public boolean existsName(String name){

        for(Person p : persons){

            if(p.getName().equals(name)){

                return true;
            }
        }
        return false;
    }

    public boolean contains(Person pers){

        for(Person p : persons){

            if(p.equals(pers)){

                return true;
            }
        }
        return false;
    }

    public int size(){

        int count = 0;
        for(Person p:persons){

            count++;
        }
        return count;
    }

    public boolean isEmpty(){

        if(size() == 0){

            return true;
        }
        return false;
    }

    public int getIdByName(String name){

        for(Person p : persons){

            if(p.getName().equals(name)){

                return p.getId();
            }
        }
        return -1;
    }

    public void modifyPerson(int id, String name, int age, double height, String password){

        Person pers = getPersonById(id);

        if(pers.getId() != -1){

            pers.setName(name);
            pers.setAge(age);
            pers.setHeight(height);
            pers.setPassword(password);
        }

        System.out.println("\nNu exista o persoana cu acest id");
    }

    public void modifyStaff(int id, String name, int age, double height, String password, String department, double salary){

        Person p = getPersonById(id);

        try {
            Staff st = (Staff) p;
            st.setName(name);
            st.setDepartment(department);
            st.setAge(age);
            st.setPassword(password);
            st.setHeight(height);
            st.setSalary(salary);

        }catch(Exception e){

            System.out.println("\nEroare");
        }
    }

    public void modifyCustomer(int id, String name, int age, double height, String password, String address, String phone){

        Person p = getPersonById(id);

        try {
            Customer c = (Customer) p;
            c.setName(name);
            c.setAddress(address);
            c.setAge(age);
            c.setHeight(height);
            c.setPhone(phone);
            c.setPassword(password);

        }catch(Exception e){

            System.out.println("\nEroare");
        }
    }

    public Person getPersonByNameAndPassword(String name, String password){

        for(Person p : persons){

            if(p.getName().equals(name) && p.getPassword().equals(password)){

                return p;
            }
        }
        return null;
    }

    public int getNumberOfPersonsWithThisName(String name){

        int count = 0;
        for(Person p:persons){
            if(p.getName().equals(name)){

                count++;
            }
        }
        return count;
    }
}
