package com.company.controller;


import com.company.model.car.Buss;
import com.company.model.car.Car;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllCar {


    private ArrayList<Car> cars;

     public ControllCar() {

         cars = new ArrayList<>();

         this.load();
     }

     public void load()  {

         try {

             File f = new File("C:\\Users\\Cosmin\\MeditatiiInformatica\\MyCode\\JavaCore\\car-management\\src\\com\\company\\resources\\cars.txt");
             Scanner cin = new Scanner(f);
             while(cin.hasNextLine()){
                 String text = cin.nextLine();
                 switch(text.split(",")[4]){

                     case "Car" : cars.add(new Car(text));
                         break;

                     case "Buss" : cars.add(new Buss(text));
                         break;
                 }
             }
         }catch(Exception e){}

     }

     public void saveToFile(){

         try{

             File f = new File("C:\\Users\\Cosmin\\MeditatiiInformatica\\MyCode\\JavaCore\\car-management\\src\\com\\company\\resources\\cars.txt");
             FileWriter fw = new FileWriter(f);
             PrintWriter pw = new PrintWriter(fw);
             pw.print(this);
             pw.close();

         }catch(Exception e){}
     }

     @Override
     public String toString(){

         String text = "";
         for(Car c : cars){

             text += c + "\n";
         }

         return text;
     }

     public int getNextAvailableID(){
         return this.cars.get(cars.size()-1).getId()+1;

     }

     public boolean existsId(int id){

         for(Car c : cars){
             if(c.getId() == id){

                 return true;
             }
         }

         return false;
     }

     public void add (Car c){
         if(!existsId(c.getId())){

             cars.add(c);
         }else{

             System.out.println("Exista deja o masina cu acest ID");
         }
     }//

     public void traverse(){

         for(Car c : cars){

             System.out.println("\n" + c.describe());
         }
     }//

     public int indexOf(Car c){

         return cars.indexOf(c);
     }//

     public void remove(int index){

         cars.remove(index);
     }//

     public void remove(Car c){

         cars.remove(c);
     }//

    public boolean contains(Car c){

         return cars.contains(c);
    }//

    public boolean isEmpty(){

         if(cars.size() > 0){
             return false;
         }
         return true;
    }//

    public int size(){return cars.size();}

    public Car getCarById(int id){

         for(Car c : cars){

             if(c.getId() == id){

                 return c;
             }
         }
         return (new Car());
    }

    public void modifyCar(int id, String brand, String model, int year){

        Car c = getCarById(id);
        if(c.getId() != -1){

            c.setBrand(brand);
            c.setModel(model);
            c.setYear(year);

            System.out.println("Masina modificata cu succes");
        }else{
            System.out.println("Nu exista aceasta masina");
        }
    }

    public void modifyBuss(int id, String brand, String model, int year, int capacity, double len){

         Car c = getCarById(id);

         if(id != -1){

             try{

                 Buss b = (Buss) c;

                 b.setBrand(brand);
                 b.setModel(model);
                 b.setYear(year);
                 b.setCapacity(capacity);
                 b.setLength(len);
             }
             catch(Exception e){
                 System.out.println("\nEroare");
             }
         }
    }

    public int getIdByBrandAndModel(String brand, String model){

         for(Car c : cars){

             if(c.getBrand().equals( brand) && c.getModel().equals(model)){

                 return c.getId();
             }
         }
         return -1;
    }

}
