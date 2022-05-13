package com.company;

import java.util.Scanner;

public class Main {
    public static void bookTicket(Passenger p)
    {
        TicketBooker tb=new TicketBooker();
        if(TicketBooker.aWL ==0)
        {
            System.out.println("no tickets available");
            return;
        }
        if((p.berthprefer.equals("l") && TicketBooker.aLB >0)||
                (p.berthprefer.equals("m") && TicketBooker.aMB >0)||
                (p.berthprefer.equals("u") && TicketBooker.aUB >0)){

            System.out.println("Preferred berth available");
            if(p.berthprefer.equals("l")){
                System.out.println("lower berth alloted");
                tb.bookTicket(p,(TicketBooker.lBP.get(0)),"l");
                TicketBooker.lBP.remove(0);
                TicketBooker.aLB--;
            }
            else if(p.berthprefer.equals("m")){
                System.out.println("middle berth alloted");
                tb.bookTicket(p,(TicketBooker.mBP.get(0)),"m");
                TicketBooker.mBP.remove(0);
                TicketBooker.aMB--;
            }
            else if(p.berthprefer.equals("u")){
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
        else if(TicketBooker.aRAC>0)
        {
            System.out.println("rac alloted");
            tb.bookRac(p,TicketBooker.rac.get(0),"rac");
            TicketBooker.rac.remove(0);
            TicketBooker.aRAC--;

        }
        else if(TicketBooker.aWL>0)
        {
            System.out.println("waiting list alloted");
            tb.bookwl(p,TicketBooker.wl.get(0),"wl");
            TicketBooker.wl.remove(0);
            TicketBooker.aWL--;

        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean loop=true;

        while(loop)
        {
            System.out.println("select the module \n 1.book ticket\n 2.print ticket\n 3.cancel ticket \n 4.available ticket \n 5.exit");
            int module=sc.nextInt();
            switch (module)
            {
                case 1:
                    System.out.println("enter passenger details\nname-age-berth preference:u,m,l");
                    String name=sc.next();
                    int age=sc.nextInt();
                    String berthprefer=sc.next();
                    Passenger p= new Passenger(name,age,berthprefer);
                    bookTicket(p);
                    break;

                case 2:
                    System.out.println("print passenger ticket \n enter id to view");
                    int vid= sc.nextInt();
                    TicketBooker tb=new TicketBooker();
                    tb.printpassenger(vid);
                    break;

                case 3:
                    System.out.println("cancel ticket\n enter id ");
                    int cancelid= sc.nextInt();
                    TicketBooker tb1=new TicketBooker();
                    tb1.cancelticket(cancelid);
                    break;

                case 4:
                    System.out.println("print available ticket");
                    TicketBooker tb2=new TicketBooker();
                    tb2.availableticket();
                    break;

                case 5:
                    loop= false;
                    break;


            }
        }
    }
}
