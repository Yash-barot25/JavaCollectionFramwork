package com.company.yash.Theatre1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterfacesIntro {
    public static void main(String[] args) {
        Theatre mythatre = new Theatre("Cineplex", 10,10);

        List<Theatre.Seat> seats = new ArrayList<>(mythatre.getList());
        printList(seats);


        seats.add(mythatre.new Seat("B00", 12));
        seats.add(mythatre.new Seat("C00", 30));
        seats.sort(Theatre.comparator);
        printList(seats);

    }

    private static void printList(List<Theatre.Seat> seats){
        for (Theatre.Seat seat : seats){
            System.out.print(seat.getSeatNumber() + " $" + seat.getPrice() + " ");
        }
        System.out.println();
        System.out.println("==========================================");
    }
}
