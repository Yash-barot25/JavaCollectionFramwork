package com.company.yash.Theatre1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Theatre {

    private final String theatreName;
    private List<Seat> seats = new ArrayList<Seat>();

   public static Comparator<Seat> comparator = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if (seat1.getPrice() > seat2.getPrice()){
                return 1;
            }else if(seat1.getPrice() < seat2.getPrice()){
                return -1;
            }else{
                return 0;
            }
        }
    };

    public Theatre(String name, int rows, int seatNum) {
        this.theatreName = name;
        int lastRow = 'A' + (rows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNumber = 1; seatNumber <= seatNum; seatNumber++) {
                double price = 12.00;
            if((row > 'C' && row <= 'F' )&& (seatNumber > 3 && seatNumber < 7 )){
                price = 14.00;

            }else if(row > 'F' && (seatNumber < 3 || seatNumber > 7)){
                price = 7.00;
            }

                Seat seat = new Seat(row + String.format("%02d", seatNumber), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {

        Seat mySeat = null;
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                mySeat = seat;
                break;
            }
        }

        if (mySeat == null) {
            System.out.println("There is no such " + seatNumber + " seat in system.");
            return false;
        }

        return mySeat.reserve();

    }

    public boolean cancelSeat(String seatNumber) {

        Seat mySeat = null;
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                mySeat = seat;
                break;
            }
        }

        if (mySeat == null) {
            System.out.println("There is no such " + seatNumber + " seat in system.");
            return false;
        }

        return mySeat.cancel();

    }

    void printSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    Collection<Seat> getList(){
        return seats;
    }

    class Seat implements Comparable<Seat>{

        private final String seatNumber;
        private boolean reserved = false;
        private double price;

        Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public int compareTo(Seat o) {
            return this.seatNumber.compareToIgnoreCase(o.seatNumber);
        }

        private boolean reserve() {
            if (!reserved) {
                reserved = true;
                System.out.println(seatNumber + " is reserved.");
                return true;
            } else {
                System.out.println(seatNumber + " is already reserved.");
                return false;
            }
        }

        private boolean cancel() {
            if (reserved) {
                reserved = false;
                System.out.println(seatNumber + " is cancelled .");
                return true;
            } else {
                System.out.println(seatNumber + " is not reserved.");
                return false;
            }
        }

        String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }

}
