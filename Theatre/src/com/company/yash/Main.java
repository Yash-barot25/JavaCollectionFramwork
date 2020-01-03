package com.company.yash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre myTheatre = new Theatre("Cineplex", 8, 12);
        myTheatre.getSeats();

        myTheatre.reserveSeat("F10",12);
        myTheatre.reserveSeat("C08",23);

        List<Theatre.Seat> priceList = new ArrayList<>(Theatre.seats);
        printList(priceList);

        Collections.sort(priceList,Theatre.priceCompare);
        printList(priceList);





    }
    private static void printList(List<Theatre.Seat> list){
        for (Theatre.Seat seat : list){
            System.out.print(seat.getSeatNumber() + " " + seat.getPrice() + " ");
        }
        System.out.println("================================");
    }
}
