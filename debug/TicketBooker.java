package com.company;

import java.util.*;

public class TicketBooker {
    static int aLB=1;
    static int aMB=1;
    static int aUB=1;
    static int aRac=1;
    static int aWl=1;

    static List<Integer> lBP=new ArrayList<>(Arrays.asList(1));
    static List<Integer> mBP=new ArrayList<>(Arrays.asList(1));
    static List<Integer> uBP=new ArrayList<>(Arrays.asList(1));
    static List<Integer> rac=new ArrayList<>(Arrays.asList(1));
    static List<Integer> wl=new ArrayList<>(Arrays.asList(1));

    static List<Integer> bookedlist=new ArrayList<>();
    static Queue<Integer> racqueue=new LinkedList<>();
    static Queue<Integer> wlqueue=new LinkedList<>();

    static Map<Integer,Passenger> passengerdetail=new HashMap<>();

    public void bookTicket(Passenger p,int seatnum,String allotedberth)
    {
        p.seatnum=seatnum;
        p.alloted=allotedberth;
        passengerdetail.put(p.pid,p);
        bookedlist.add(p.pid);
        System.out.println("---booked succuessfully---");
    }
    public void bookRac(Passenger p,int racnum, String alloted)
    {
        p.seatnum=racnum;
        p.alloted=alloted;
        racqueue.add(p.pid);
        passengerdetail.put(p.pid,p);

    }
    public void bookwl(Passenger p,int wlnum, String alloted)
    {
        p.seatnum=wlnum;
        p.alloted=alloted;
        wlqueue.add(p.pid);
        passengerdetail.put(p.pid,p);
    }
    public void printticket()
    {
        for(Passenger p:passengerdetail.values())
        {
            System.out.println("id-"+p.pid);
            System.out.println("name-"+p.name);
            System.out.println("age-"+p.age);
            System.out.println("alloted berth-"+p.alloted);
            System.out.println("seatnum-"+p.seatnum);
        }
    }
    public void availableticket()
    {
        System.out.println("lb-"+aLB);
        System.out.println("mb-"+aMB);
        System.out.println("ub-"+aUB);
        System.out.println("rac-"+aRac);
        System.out.println("wl-"+aWl);
    }
    public void cancelticket(int id)
    {
        if(!passengerdetail.containsKey(id))
        {
            System.out.println("no details found");
        }
        Passenger cancelp=passengerdetail.get(id);
        passengerdetail.remove(id);
        bookedlist.remove(id);

        int positionbook=cancelp.seatnum;
        System.out.println("---cancelled successfully---");
        if(cancelp.alloted.equals("l"))
        {
            lBP.add(positionbook);
            aLB++;
        }
        else if(cancelp.alloted.equals("m"))
        {
            mBP.add(positionbook);
            aMB++;
        }
        else if(cancelp.alloted.equals("u"))
        {
            uBP.add(positionbook);
            aUB++;
        }

        if(racqueue.size()>0)
        {
            Passenger passengerrac=passengerdetail.get(racqueue.poll());
            int racposition=passengerrac.seatnum;
            rac.add(racposition);
            aRac++;
            racqueue.remove(passengerrac.pid); //emptying queue to add wl passenger to rac queue

            if(wlqueue.size()>0)
            {
                Passenger passengerwl=passengerdetail.get(wlqueue.poll());
                int wlposition=passengerwl.seatnum;
                wl.add(wlposition);
                wlqueue.remove(passengerwl.pid);


                passengerwl.seatnum=rac.get(0);
                passengerwl.alloted="rac";
                racqueue.add(passengerwl.pid);
                rac.remove(0);
                aWl++;
                aRac--;
            }
            Main.bookTicket(passengerrac);
        }
    }
}