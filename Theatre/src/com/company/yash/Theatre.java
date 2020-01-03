package com.company.yash;

import java.util.*;

public class Theatre {
    private  final String name;
   public static List<Seat> seats = new ArrayList<>();

   static final Comparator<Seat> priceCompare = new Comparator<Seat>() {
       @Override
       public int compare(Seat o1, Seat o2) {
           if (o1.getPrice() > o2.getPrice()){
               return 1;
           }else if (o1.getPrice() < o2.getPrice()){
               return -1;
           }else{
               return 0;
           }
       }
   };


     Theatre(String name,int rowNum,int seatsPerRow){
        this.name = name;
        int lastrow = 'A' + (rowNum - 1);
        for (char row = 'A';row<=lastrow;row++){
            for (int i = 1;i<= seatsPerRow;i++){
                double price  = 12.00;
                if (row < 'E' && (i > 4 && i < 9)){
                    price = 14.00;
                }else if (row > 'F'){
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d",i),price);
                seats.add(seat);
            }
        }
    }

     void getSeats(){
        for (Seat seat: seats){
            System.out.print(seat.getSeatNumber() + " " + seat.getPrice() + " ");
        }
         System.out.print("\n");
    }

      void reserveSeat(String number,double price){
//         int low = 0;
//         int high = seats.size() - 1;
//
//         while(low <= high){
//
//             int mid = (low + high) /2;
//             Seat seat = new Seat(seats.get(mid).getSeatNumber());
//             int cmp = seat.seatNumber.compareToIgnoreCase(number);
//             if (cmp < 0){
//                 low = mid +1;
//
//             }else if (cmp > 0){
//                 high = mid - 1;
//             }else{
//                 seat.reserve();
//                 return;
//             }
//         }
//          System.out.println(number + " seat didn't found.");


         Seat seat = new Seat(number,price);
         int cmp = Collections.binarySearch(seats,seat,null);
         if (cmp >= 0){
             seat.reserve();
         }else{
             System.out.println(number + " seat didn't found.");
         }
          //======================================================
//        Seat reserveSeat = null;
//        for (Seat seat: seats){
//            System.out.print(".");
//            if (number.equals(seat.getSeatNumber())){
//                reserveSeat = seat;
//            }
//        }
//
//        if (reserveSeat != null){
//            reserveSeat.reserve();
//
//        }else {
//            System.out.println(number + " seat didn't found");
//        }

    }


     void cancelSeat(String number){
        Seat reserveSeat = null;
        for (Seat seat: seats){
            if (number.equals(seat.getSeatNumber())){
                reserveSeat = seat;
            }
        }

        if (reserveSeat != null){
            reserveSeat.cancel();
        }else {
            System.out.println(number + " seat can't found.");
        }

    }


    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;
        private double price;

         Seat(String name,double price){
            seatNumber = name;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        void reserve(){

            if (!reserved){
                reserved = true;
                System.out.println(seatNumber +  " is successfully reserved.");

            }else{
                System.out.println(seatNumber + " is already reserved");
            }
        }
        void cancel(){
            if (reserved){
                reserved = false;
                System.out.println(seatNumber +  " is successfully canceled.");

            }else{
                System.out.println(seatNumber +  " can't be canceled.");

            }
        }

        public double getPrice() {
            return price;
        }

        String getSeatNumber(){
             return seatNumber;
        }
    }

}