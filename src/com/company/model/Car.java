package com.company.model;

public class Car {

    private int id;
    private String brand;
    private String model;
    private int year;

    public Car(){

        this.id = -1;
        this.model = "Anonim";
        this.brand = "Anonim";
        this.year = 0;
    }

    public Car(int id, String brand, String model, int year){

        this.id = id;
        this.model = model;
        this.brand = brand;
        this.year = year;
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

    @Override
    public String toString(){
        String text = "";
        text += "ID : " + id;
        text += "\nBrand : " + brand;
        text += "\nModel : " + model;
        text += "\nYear : " + year;
        return text;
    }


    @Override
    public boolean equals(Object o){
        Car car=(Car) o;//downcasting
        return (this.id == car.getId() && this.brand == car.brand && this.model == car.model && this.year == car.year);

    }



}
