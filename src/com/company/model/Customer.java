package com.company.model;


public class Customer extends Person {

    protected String address;
    protected String phone;
    protected String password;



    public String getAddress(){return address;}
    public String getPhone(){return phone;}
    public String getPassword(){return password;}

    public void setAddress(String adr){address = adr;}
    public void setPhone(String ph){phone = ph;}
    public void setPassword(String pass){password = pass;}


    public Customer(int id, String name, int age, double h, String type, String address, String phone, String password){

        super(id,name,age,h, "Customer");
        this.address = address;
        this.phone = phone;
        this.password = password;
    }

    public Customer(){

        super();
        setType("Customer");
        this.address = "None";
        this.phone = "0000000000";
        password = "1234";
    }

    public Customer(String prp){

        String [] v = prp.split(",");

        setId(Integer.parseInt(v[0]));
        setName(v[1]);
        setAge(Integer.parseInt(v[2]));
        setHeight(Double.parseDouble(v[3]));
        setType("Customer");
        address = v[5];
        phone = v[6];
        password = v[7];
    }

    @Override
    public String toString(){

        return (getId() + "," + getName() + "," + getAge() + "," + getHeight() + "," + getType() + "," + address + "," + phone + "," + password);

    }

    @Override
    public String describe(){

        String text = "";
        text += "\nID : " + getId();
        text += "\nName : " + getName();
        text += "\nAge : " + getAge();
        text += "\nHeight : " + getHeight();
        text += "\nAddress : " + address;
        text += "\nPhone : " + phone;
        text += "\nType : Customer";

        return text;
    }
}
