package com.company.model;

public class Car {

    private int id;
    private String brand;
    private String model;
    private int year;
    private String type;

    public Car(){

        this.id = -1;
        this.model = "Anonim";
        this.brand = "Anonim";
        this.year = 0;
        type = "Car";
    }

    public Car(int id, String brand, String model, int year, String type){

        this.id = id;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.type = "Car";
    }

    public Car(String prp){

        String[] v =prp.split(",");
        id = Integer.parseInt(v[0]);
        brand = v[1];
        model = v[2];
        year = Integer.parseInt(v[3]);
        type = "Car";
    }

//    Settari :

    public int getId(){
        return this.id;
    }

    public String getBrand(){
        return this.brand;
    }

    public String getModel(){
        return this.model;
    }

    public int getYear(){
        return this.year;
    }

    public String getType(){return this.type;}


    //Gettari:
    public void setId(int id){
        this.id = id;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setType(String ty){this.type = ty;}

    @Override
    public String toString(){

        return id + "," + brand + "," + model + "," + year + "," + type;
    }

    public String describe(){

        String text = "";
        text += "ID : " + id;
        text += "\nBrand : " + brand;
        text += "\nModel : " + model;
        text += "\nYear : " + year;
        text += "\nType : Car";
        return text;
    }

    @Override
    public boolean equals(Object o){
        Car car=(Car) o;//downcasting
        return (this.id == car.getId());

    }



}
