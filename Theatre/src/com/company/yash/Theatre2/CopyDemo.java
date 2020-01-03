package com.company.yash.Theatre2;

import com.company.yash.Theatre1.Theatre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CopyDemo {
    public static void main(String[] args) {
        TheatreWithAlgos myTheatre = new TheatreWithAlgos("Cineplex", 8 , 8);
        List<TheatreWithAlgos.Seat> seats = new ArrayList<>(myTheatre.seats);
        printList(seats);
        seats.get(1).reserve();
        myTheatre.reserveSeat("A02");
        Collections.reverse(seats);
        System.out.println("Copied list: ");
        printList(seats);
        System.out.println("Original list: ");
        printList(myTheatre.seats);

        TheatreWithAlgos.Seat minSeat = Collections.min(seats);
        TheatreWithAlgos.Seat maxSeat = Collections.max(myTheatre.seats);
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        Collections.shuffle(seats);
        System.out.println("Copied list after shuffling: ");
        printList(seats);

        listSort(seats);
        System.out.println("Copied list after sorting: ");
        printList(seats);

    }

    private static void printList(List<TheatreWithAlgos.Seat> seats){
        for (TheatreWithAlgos.Seat seat: seats){
            System.out.print(seat.getSeatNumber()  + " ");
        }
        System.out.println();
        System.out.println("===========================================");
    }

    private static void listSort(List<? extends TheatreWithAlgos.Seat> seats){
        for (int i = 0; i < seats.size()-1; i++){
            for (int j = i+1; j < seats.size(); j++){
                if (seats.get(i).compareTo(seats.get(j)) > 0){
                    Collections.swap(seats, i, j);
                }
            }
        }
    }

}
