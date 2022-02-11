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
            File file = new File("src/com/company/resources/persons.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                switch (text.split(",")[4]){
                    case "Staff":this.persons.add(new Staff(text));
                    break;
                    case "Customer":this.persons.add(new Customer(text));
                    break;
                }
            }


        }catch (Exception e){

        }


    }

    public Person getPersonById(int id){

        for(Person p : persons){

            if(p.getId() == id) {

                return p;
            }
        }
        return (new Person());
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
            File file = new File("src/com/company/resources/persons.txt");

            FileWriter fileWriter = new FileWriter(file);

            PrintWriter printWriter= new PrintWriter(fileWriter);

            printWriter.print(this.toString());

            printWriter.close();

        }catch (Exception e){

        }
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

    public void modifyPerson(int id, String name, int age, double height){

        Person pers = getPersonById(id);

        if(pers.getId() != -1){

            pers.setName(name);
            pers.setAge(age);
            pers.setHeight(height);
        }

        System.out.println("\nNu exista o persoana cu acest id");
    }

    public void modifyStaff(int id, String name, int age, double height, String department, double salary, String password){

        Person p = getPersonById(id);

        try {
            Staff st = (Staff) p;
            st.setName(name);
            st.setDepartment(department);
            st.setAge(age);
            st.setHeight(height);
            st.setSalary(salary);
            st.setPassword(password);

        }catch(Exception e){

            System.out.println("\nEroare");
        }
    }

    public void modifyCustomer(int id, String name, int age, double height, String address, String phone, String password){

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

            if(p.getName().equals(name)){

                if(p.getType() == "Customer"){

                    Customer c = (Customer) p;

                    if(c.getPassword().equals(password)){return c;}
                }
                else if(p.getType() == "Staff"){

                    Staff s = (Staff) p;

                    if(s.getPassword().equals(password)){return s;}
                }
            }
        }
        return new Person();
    }


}
