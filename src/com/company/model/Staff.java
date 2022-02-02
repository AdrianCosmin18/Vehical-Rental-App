package com.company.model;

public class Staff extends Person{

    protected String department;
    protected double salary;


    public String getDepartment(){return department;}
    public double getSalary(){return salary;}

    public void setDepartment(String dept){department = dept;}
    public void setSalary(double sal){salary = sal;}

    public Staff(){

        super();
        setType("Staff");
        department = "None";
        salary = 0;
    }

    public Staff(String prp){

        String [] v = prp.split(",");

        setId(Integer.parseInt(v[0]));
        setName(v[1]);
        setAge(Integer.parseInt(v[2]));
        setHeight(Double.parseDouble(v[3]));
        setType("Staff");
        department = v[5];
        salary = Double.parseDouble(v[6]);
    }

    public Staff(int id, String name, int age, double h, String type, String dept, double salary){

        super(id, name, age, h, "Staff");
        department = dept;
        this.salary = salary;
    }

    @Override
    public String toString(){

        return (getId() + "," + getName() + "," + getAge() + "," + getHeight() + "," + getType() + "," + department + "," + salary);
    }

    @Override
    public String describe(){

        String text = "";
        text += "\nID : " + getId();
        text += "\nName : " + getName();
        text += "\nAge : " + getAge();
        text += "\nHeight : " + getHeight();
        text += "\nDepartment : " + department;
        text += "\nSalary : " + salary;
        text += "\nType : Staff";

        return text;
    }
}
