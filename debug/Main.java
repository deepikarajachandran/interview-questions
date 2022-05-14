package com.company;

import java.util.Scanner;

public class Main {
    public static void bookTicket(Passenger p)
    {
        TicketBooker tb=new TicketBooker();
        if(TicketBooker.aWl==0)
        {
            System.out.println("no tickets available");
            return;
        }
        if((p.berthprefer.equals("l") && TicketBooker.aLB>0)||
                (p.berthprefer.equals("m") && TicketBooker.aMB>0)||
                (p.berthprefer.equals("u") && TicketBooker.aUB>0))
        {
            System.out.println("Preferred berth available");
            if(p.berthprefer.equals("l"))
            {
                System.out.println("lower berth alloted");
                tb.bookTicket(p,TicketBooker.lBP.get(0),"l");
                TicketBooker.lBP.remove(0);
                TicketBooker.aLB--;
            }
            else if(p.berthprefer.equals("m"))
            {
                System.out.println("middle berth alloted");
                tb.bookTicket(p,TicketBooker.mBP.get(0),"m");
                TicketBooker.mBP.remove(0);
                TicketBooker.aMB--;
            }
            else if(p.berthprefer.equals("u"))
            {
                System.out.println("upper berth alloted");
                tb.bookTicket(p,TicketBooker.uBP.get(0),"u");
                TicketBooker.uBP.remove(0);
                TicketBooker.aUB--;
            }
        }
        else if(TicketBooker.aLB>0)
        {
            System.out.println("lower berth alloted");
            tb.bookTicket(p,TicketBooker.lBP.get(0),"l");
            TicketBooker.lBP.remove(0);
            TicketBooker.aLB--;
        }
        else if(TicketBooker.aMB>0)
        {
            System.out.println("middle berth alloted");
            tb.bookTicket(p,TicketBooker.mBP.get(0),"m");
            TicketBooker.mBP.remove(0);
            TicketBooker.aMB--;
        }
        else if(TicketBooker.aUB>0)
        {
            System.out.println("upper berth alloted");
            tb.bookTicket(p,TicketBooker.uBP.get(0),"u");
            TicketBooker.uBP.remove(0);
            TicketBooker.aUB--;
        }
        else if(TicketBooker.aRac>0)
        {
            System.out.println("rac alloted");
            tb.bookRac(p,TicketBooker.rac.get(0),"rac");
            TicketBooker.rac.remove(0);
            TicketBooker.aRac--;
        }
        else if(TicketBooker.aWl>0)
        {
            System.out.println("waitinglist alloted");
            tb.bookRac(p,TicketBooker.wl.get(0),"wl");
            TicketBooker.wl.remove(0);
            TicketBooker.aWl--;
        }

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean loop=true;
        while(loop)
        {
            System.out.println("select a module 1.book ticket 2.print ticket 3.available ticket 4.cancel ticket 5.exit");
            int choice= sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("booking ticket\nenter name,age,preference-U,M,L");
                    String name= sc.next();
                    int age= sc.nextInt();
                    String berthprefer= sc.next();
                    Passenger p=new Passenger(name,age,berthprefer);
                    bookTicket(p);
                    break;

                case 2:
                    System.out.println("print ticket");
                    TicketBooker tb1=new TicketBooker();
                    tb1.printticket();
                    break;

                case 3:
                    System.out.println("available ticket");
                    TicketBooker tb2=new TicketBooker();
                    tb2.availableticket();
                    break;

                case 4:
                    System.out.println("cancel ticket\nenter id to cancel");
                    int id= sc.nextInt();
                    TicketBooker tb3=new TicketBooker();
                    tb3.cancelticket(id);
                    break;

                case 5:
                    loop=false;
                    break;

            }
        }

    }
}
