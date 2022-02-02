package com.company.controller;


import com.company.model.Car;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ControllCar {


    private ArrayList<Car> cars;

     public ControllCar(){

         cars=  new ArrayList<>();

         cars.add(new Car(0, "Skoda", "Octavia 4", 2021));
         cars.add(new Car(1,"Wolkswagen", "Passat CC", 2017));
         cars.add(new Car(2,"Dacia", "Logan MCV", 2018));

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

             System.out.println("\n" + c);
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

    public void modify(int id, String brand, String model, int year){

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

    public int getIdByBrandAndModel(String brand, String model){

         for(Car c : cars){

             if(c.getBrand().equals( brand) && c.getModel().equals(model)){

                 return c.getId();
             }
         }
         return -1;
    }

}
