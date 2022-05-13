package com.company;

import java.util.*;

public class TicketBooker {

    static int aLB=1;
    static int aMB=1;
    static int aUB=1;
    static int aWL=1;
    static int aRAC=1;

    static List<Integer> lBP=new ArrayList<>(Arrays.asList(1));
    static List<Integer> mBP=new ArrayList<>(Arrays.asList(1));
    static List<Integer> uBP=new ArrayList<>(Arrays.asList(1));
    static List<Integer> rac=new ArrayList<>(Arrays.asList(1));
    static List<Integer> wl=new ArrayList<>(Arrays.asList(1));

    static List<Integer> bookedlist=new ArrayList<>();
    static Queue<Integer> waitinglist=new LinkedList<>();
    static Queue<Integer> raclist=new LinkedList<>();


    static Map<Integer,Passenger> passengerdetail=new HashMap<>();

    public void bookTicket(Passenger p,int berthnum, String allotedberth)
    {
        p.seatnum=berthnum;
        p.alloted=allotedberth;
        passengerdetail.put(p.pid,p);
        bookedlist.add(p.pid);
        System.out.println("---booked successfully---");
    }
    public void bookRac(Passenger p,int racnum,String allotedrac)
    {
        p.seatnum=racnum;
        p.alloted=allotedrac;
        passengerdetail.put(p.pid,p);
        raclist.add(p.pid);
    }
    public void bookwl(Passenger p,int wlnum,String allotedwl)
    {
        p.seatnum=wlnum;
        p.alloted=allotedwl;
        passengerdetail.put(p.pid,p);
        waitinglist.add(p.pid);
    }
    public void printpassenger(int vid)
    {
        if(passengerdetail.size()==0)
        {
            System.out.println("no details");
            return;
        }

        if(passengerdetail.containsKey(vid))
        {
            Passenger p=passengerdetail.get(vid);
            System.out.println("id-"+p.pid);
            System.out.println("name-"+p.name);
            System.out.println("age-"+p.age);
            System.out.println("prefer berth-"+p.berthprefer);
            System.out.println("alloted seat-"+p.alloted);
            System.out.println("seat num-"+p.seatnum);

        }
       /* for(Passenger p:passengerdetail.values())
        {
            System.out.println("id-"+p.pid);
            System.out.println("name-"+p.name);
            System.out.println("age-"+p.age);
            System.out.println("prefer berth-"+p.berthprefer);
            System.out.println("alloted seat-"+p.alloted);
            System.out.println("seat num-"+p.seatnum);
        }*/
    }
    public void availableticket()
    {
        System.out.println("Available LB-"+aLB);
        System.out.println("Available MB-"+aMB);
        System.out.println("Available UB-"+aUB);
        System.out.println("Available RAC-"+aRAC);
        System.out.println("Available WL-"+aWL);
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

        if(raclist.size()>0)
        {
            Passenger passengerrac=passengerdetail.get(raclist.poll());
            int racposition=passengerrac.seatnum;
            rac.add(racposition);
            raclist.remove(0);
            aRAC++;
            if(waitinglist.size()>0)
            {
                Passenger passengerwl=passengerdetail.get(waitinglist.poll());
                int wlposition=passengerwl.seatnum;
                wl.add(wlposition);
                waitinglist.remove(passengerwl.pid);

                passengerwl.seatnum=rac.get(0);
                passengerwl.alloted="rac";
                raclist.add(passengerwl.pid);
                rac.remove(0);

                aWL++;
                aRAC--;
            }
            Main.bookTicket(passengerrac);
        }

    }
}
