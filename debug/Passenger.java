package com.company;

public class Passenger {
    public static int id=1;
    String name;
    int age;
    String berthprefer;
    int pid;
    String alloted;
    int seatnum;
    Passenger(String name,int age,String berthprefer)
    {
        this.name=name;
        this.age=age;
        this.berthprefer=berthprefer;
        this.pid=id++;
        this.alloted="";
        this.seatnum=-1;
    }
}
