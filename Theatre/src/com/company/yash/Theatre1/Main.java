package com.company.yash.Theatre1;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String seat;

    public static void main(String[] args) {
        // write your code here
        Theatre myTheatre = new Theatre("Wide angel", 10, 8);
        System.out.println("Welcome to " + myTheatre.getTheatreName());
        // myTheatre.printSeats();

        breakMe:
        while (true) {
            System.out.println("0.To exit\n1.To print seats.\n2.To reserve seat.\n3.To cancel reserved seat.");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    break breakMe;
                case 1:
                    myTheatre.printSeats();
                    break;
                case 2:
                    System.out.println("Enter seat number: \n");
                    seat = scanner.next();
                    if (myTheatre.reserveSeat(seat)) {
                        System.out.println("Please pay");
                    } else {
                        System.out.println("Please try again...!");
                    }
                    break;
                case 3:
                    System.out.println("Enter seat number: \n");
                    seat = scanner.next();
                    myTheatre.cancelSeat(seat);
                default:
                    System.out.println("Invalid option:");

            }
        }
      scanner.close();

    }
}
