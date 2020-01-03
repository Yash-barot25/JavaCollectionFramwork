package com.company.yash.Theatre2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheatreWithAlgos {

    private final String theatreName;
    public List<Seat> seats = new ArrayList<Seat>();

    public TheatreWithAlgos(String name, int rows, int seatNum) {
        this.theatreName = name;
        int lastRow = 'A' + (rows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNumber = 1; seatNumber <= seatNum; seatNumber++) {
                Seat seat = new Seat(row + String.format("%02d", seatNumber));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat seat = new Seat(seatNumber);
        int high = seats.size() - 1;
        int low = 0;

        while (low <= high) {
            System.out.print(".");
            int mid = (high + low) / 2;
            int comp = seats.get(mid).compareTo(seat);
            if (comp > 0){
                high  = mid - 1;
            }else if(comp < 0){
                low = mid + 1;
            }else{
                return seats.get(mid).reserve();
            }


        }
        System.out.println("No such seat " + seatNumber);
        return false;

//        Seat seat = new Seat(seatNumber);
//        int comp = Collections.binarySearch(seats, seat, null);
//        if (comp >= 0) {
//            return seats.get(comp).reserve();
//        } else {
//            return false;
//        }
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

    class Seat implements Comparable<Seat> {

        private final String seatNumber;
        private boolean reserved = false;

        Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat o) {
            return this.seatNumber.compareToIgnoreCase(o.getSeatNumber());
        }

        public boolean reserve() {
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
    }

}
