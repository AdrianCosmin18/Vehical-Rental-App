package com.company.model.person;

public class Person {


    private int id;
    private String name;
    private int age;
    private double height;
    private String type;
    private String password;

    public Person(){

        id = -1;
        name = "Anonim";
        age = 18;
        height = 1.8;
        type = "Person";
        password = "1234";
    }

    public Person(int ID, String Name, int Age, double h, String ty, String pass){

        id = ID;
        name = Name;
        age = Age;
        height = h;
        type = "Person";
        password = pass;

    }

    public Person(String prp){

        String[]proprietati=prp.split(",");

        this.id = Integer.parseInt(proprietati[0]);
        this.name = proprietati[1];
        this.age = Integer.parseInt(proprietati[2]);
        this.height = Double.parseDouble(proprietati[3]);
        this.type = "Person";
        this.password = proprietati[5];
    }

    public int getId(){return id;}
    public String getName(){return name;}
    public int getAge(){return age;}
    public double getHeight(){return height;}
    public String getType(){return type;}
    public String getPassword(){return password;}

    public void setId(int ID){id = ID;}
    public void setName(String Name){name = Name;}
    public void setAge(int Age){age = Age;}
    public void setHeight(double h){height = h;}
    public void setType(String ty){type = ty;}
    public void setPassword(String pass){password = pass;}


    @Override
    public String toString(){

        return (id + "," + name + "," + age + "," + height + "," + type + "," + password);
    }

    @Override
    public boolean equals(Object obj){

        Person p = (Person) obj;//dynamic cast
        return (this.id == p.id) ;
    }

    public String describe(){

        String text = "";
        text += "\nID : " + id;
        text += "\nName : " + name;
        text += "\nAge : " + age;
        text += "\nHeight : " + height;
        text += "\nType : Person";

        return text;
    }

}
