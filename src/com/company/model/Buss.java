package com.company.model;

public class Buss extends Car{

    private int capacity;
    private double length;

    public double getLength() {
        return length;
    }
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int cap){capacity = cap;}
    public void setLength(double leng){length = leng;}

    public Buss(){

        super();
        setType("Buss");
        capacity = 0;
        length = 0;
    }

    public Buss(int id, String brand, String model, int year, String type, int capacity, double length){

        super(id, brand, model, year, "Buss");
        this.capacity = capacity;
        this.length = length;
    }

    public Buss(String prp){

        String [] v = prp.split(",");
        setId(Integer.parseInt(v[0]));
        setBrand(v[1]);
        setModel(v[2]);
        setYear(Integer.parseInt(v[3]));
        setType("Buss");
        capacity = Integer.parseInt(v[5]);
        length = Double.parseDouble(v[6]);
    }

    @Override
    public String toString(){

        return getId() + "," + getBrand() + "," + getModel() + "," + getYear() + "," + getType() + "," + capacity + "," + length;
    }

    @Override
    public String describe(){

        String text = "";
        text += "ID : " + getId();
        text += "\nBrand : " + getBrand();
        text += "\nModel : " + getModel();
        text += "\nYear : " + getYear();
        text += "\nType : Buss";
        text += "\nCapacity : " + capacity + " persons";
        text += "\nLength : " + length + " meters";
        return text;
    }


}
