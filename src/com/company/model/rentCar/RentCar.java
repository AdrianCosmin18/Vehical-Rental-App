package com.company.model.rentCar;

public class RentCar {

    private int id;
    private int idPerson;
    private int idCar;
    private String fromDate;
    private String toDate;

    public int getId(){return id;}
    public int getIdPerson(){return idPerson;}
    public int getIdCar() {return idCar;}
    public String getFromDate(){return fromDate;}
    public String getToDate(){return toDate;}

    public void setId(int id){this.id = id;}
    public void setIdPerson(int id){idPerson = id;}
    public void setIdCar(int id){idCar = id;}
    public void setFromDate(String from){fromDate = from;}
    public void setToDate(String to){toDate = to;}


    public RentCar(){

        id = -1;
        idPerson = -1;
        idCar = -1;
        fromDate = "99-12-18";
        toDate = "99-12-18";
    }

    public RentCar(int id, int idPerson, int idCar, String fromDate, String toDate){

        this.id = id;
        this.idCar = idCar;
        this.idPerson = idPerson;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public RentCar(String prp){

        String [] v = prp.split(",");
        id = Integer.parseInt(v[0]);
        idPerson = Integer.parseInt(v[1]);
        idCar = Integer.parseInt(v[2]);
        fromDate = v[3];
        toDate = v[4];
    }

    @Override
    public String toString(){

        return id + "," + idPerson + "," + idCar + "," + fromDate + "," + toDate;
    }

    public String describe(){

        String text = "";
        text += "\nID : " + id;
        text += "\nPerson ID : " + idPerson;
        text += "\nCar ID : " + idCar;
        text += "\nRent from date : " + fromDate;
        text += "\nTo date : " + toDate;

        return text;
    }

    @Override
    public boolean equals(Object o){

        RentCar rc = (RentCar) o;
        return this.id == rc.id;
    }
}
