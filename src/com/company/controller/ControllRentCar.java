package com.company.controller;

import com.company.model.rentCar.RentCar;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllRentCar {

    private ArrayList<RentCar> rents;




    public ControllRentCar(){

        rents = new ArrayList<RentCar>();
        load();
    }

    public void load() {

        try{
            File f = new File("src/com/company/resources/rentCars.txt");
            Scanner cin = new Scanner(f);
            while(cin.hasNextLine()){

                String text = cin.nextLine();
                rents.add(new RentCar(text));
            }
        }catch(Exception e){}
    }

    public void saveToFile() {

//        try{
//            File f = new File("src/com/company/resources/rentCars.txt");
//            FileWriter fw = new FileWriter(f);
//            PrintWriter pw = new PrintWriter(fw);
//            pw.print(this.toString());
//            pw.close();
//        }catch(Exception e){}

        try{

            File f = new File("src/com/company/resources/rentCars.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(RentCar r : rents){

                pw.print(r);
                pw.print("\n");
            }
            pw.close();
        }catch (Exception e){}
    }

    @Override
    public String toString(){

        String text = "";
        for(RentCar rc : rents){

            text += rc + "\n";
        }
        return text;
    }

    public void traverse(){

        for(RentCar r : rents){

            System.out.println(r.describe());
        }
    }

    public int getNextAvailableID(){

        return rents.get(rents.size() -1 ).getId() + 1;
    }

    public RentCar getRentCarByID(int id){

        for(RentCar r:rents){

            if(r.getId() == id){

                return r;
            }
        }
        return new RentCar();
    }

    public ArrayList<RentCar> getListByFromDate(String date){

        ArrayList<RentCar> list = new ArrayList<RentCar>();
        for(RentCar r:rents){

            if(r.getFromDate().equals(date)){

                list.add(r);
            }
        }
        return list;
    }

    public boolean existsID(int id){

        for(RentCar r :rents){

            if(r.getId() == id){

                return true;
            }
        }
        return false;
    }

    public void add(RentCar rc){

        if(existsID(rc.getId()) == false){

            rents.add(rc);
        }
        else{

            System.out.println("A rental with this id has already been registered");
        }
    }

    public int indexOf(RentCar rc){

        int index = -1;
        for(RentCar r : rents){

            index++;
            if(rc.equals(r)){

                return index;
            }
        }
        return -1;
    }

    public void remove(int index){

        rents.remove(index);
    }

    public void remove(RentCar rc){

        rents.remove(indexOf(rc));
    }

    public boolean contains(RentCar rc){

        for(RentCar r : rents){

            if(rc.equals(r)){

                return true;
            }
        }
        return false;
    }

    public int size(){

        return rents.size();
    }

    public boolean isEmpty(){

        if (size() == 0){

            return true;
        }
        return false;
    }

    public int getIdByPersonIdAndCarId(int personId, int carId){

        for(RentCar r : rents){

            if(r.getIdCar() == carId && r.getIdPerson() == personId){

                return r.getId();
            }
        }
        return -1;
    }

    public void modify(int id, String fromDate, String toDate){

        RentCar rc = getRentCarByID(id);
        rc.setFromDate(fromDate);
        rc.setToDate(toDate);
    }

    public ArrayList<RentCar> getListByPersonId(int personId){

        ArrayList<RentCar> list = new ArrayList<RentCar>();
        for(RentCar r : rents){

            if(r.getIdPerson() == personId){

                list.add(r);
            }
        }

        return list;
    }
}
