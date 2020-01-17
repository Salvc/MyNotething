package com.example.mynotething;

import java.io.Serializable;
import java.util.Date;

public class Sub implements Serializable {

//Fields
    private String Name;
    private String TODO1;
    private String TODO2;
    private String TODO3;

    private Date date1;
    private Date date2;
    private Date date3;


    //Constructor

    Sub(){

    }
//Getters and Setters

    public String getName(){ return Name;}

    public void setName(String name) {
        Name = name;
    }

    public String getTODO1() {
        return TODO1;
    }
    public void setTODO1(String objective){
        TODO1 = objective;


    }
    public String getTODO2() {
        return TODO2;
    }
    public void setTODO2(String objective){
        TODO2 = objective;
    }
    public String getTODO3() {
        return TODO3;
    }
    public void setTODO3(String objective){
        TODO3 = objective;

    }

    public Date getDate1() {
        return date1;
    }
    public void setDate1(Date date){
        date1 = date;
    }
    public Date getDate2() {
        return date2;
    }
    public void setDate2(Date date){
        date2 = date;

    }
    public Date getDate3() {
        return date3;
    }
    public void setDate3(Date date){
        date3 = date;

    }

}
