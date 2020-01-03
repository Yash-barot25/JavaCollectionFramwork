package com.company.yash.Theatre2;

public class Main {
    public static void main(String[] args) {
        TheatreWithAlgos myTheatre = new TheatreWithAlgos("cineplex", 10, 10);

       if ( myTheatre.reserveSeat("E10"))
           System.out.println("Please pay");

        if ( myTheatre.reserveSeat("e10"))
            System.out.println("Please pay");
    }
}
