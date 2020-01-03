package com.company.yash;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroceryList {
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {

            System.out.println("Enter your choice...");
            System.out.println("\t0. To Exit");
            System.out.println("\t1. Print grocery list");
            System.out.println("\t2. Enter new Item in Grocery list");
            System.out.println("\t3. Delete an item from list");
            System.out.println("\t4. search an item from list");
            System.out.println("\t5. modify an item from list");
            System.out.println("\t6. Convert List To an Array & print content");
            System.out.println("\t7. Create another list and copy content of grocery list & print out.");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 0:
                    System.out.println("Good  Bye");
                    flag = false;
                    break;
                case 1:
                    printList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    deleteItem();
                    break;
                case 4:
                    serachItem();
                    break;
                case 5:
                    mofidyItem();
                    break;
                case 6:
                    toArray();
                    break;
                case 7:
                    anotherArrayList();
                    break;
                default:
                    System.out.println("Please enter a valid choice...");
                    break;
            }


        }
    }

    private static void toArray(){

        String[] strArray = new String[groceryList.size()];
        strArray = groceryList.toArray(strArray);
        for (int i = 0; i < strArray.length;i++){
            System.out.println(strArray[i]);
        }

    }

    private static void anotherArrayList(){
        List<String> anotherList = new ArrayList<>(groceryList);
        for (int i = 0; i < anotherList.size();i++){
            System.out.println(anotherList.get(i));
        }
        System.out.println("\n==================\n");
        anotherList = new ArrayList<>();
        anotherList.addAll(groceryList);
        for (int i = 0; i < anotherList.size();i++){
            System.out.println(anotherList.get(i));
        }

    }

    private static void printList() {
        if (groceryList.size() != 0) {


        System.out.print("Grocery List...\n");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }}else {
            System.out.println("Grocery list is empty...");
        }
    }

    private static void addItem() {
        System.out.println("Enter a item you wants to add in grocery list.");
        String item = scanner.nextLine();
        groceryList.add(item);
        System.out.println("Item added.");
    }

    private static void deleteItem() {
        System.out.println("How would you like to delete item.\n\t1. By name\n\t2. By index");
        int value = scanner.nextInt();
        scanner.nextLine();
        if (value == 1) {
            System.out.println("Enter a name of a item...");
            String item = scanner.nextLine();
            int index = groceryList.indexOf(item);
            if (index == -1) {
                System.out.println("Item doesn't exist");
            } else {
                groceryList.remove(index);
                System.out.println("Item removed from list");
            }
        } else if (value == 2) {
            System.out.println("Enter a index of an item to remove");
            value = scanner.nextInt();
            if (value > 0 && value -1 < groceryList.size()) {
                groceryList.remove(value-1);
                System.out.println("Item removed");
            } else {
                System.out.println("Invalid index...!");
            }
        } else {
            System.out.println("Invalid choice...");
        }

    }

    private static void serachItem() {
        System.out.println("Enter a item name to search in grocery list");
        String item = scanner.nextLine();
        int index = groceryList.indexOf(item);
        if (index == -1) {
            System.out.println("Item doesn't found!!!");
        } else {
            System.out.println(item + " Found in grocery list.\nWhich is at position " + (index + 1));
        }
    }

    private static void mofidyItem(){
        System.out.println("How would you like to delete item.\n\t1. By name\n\t2. By index");
        int value = scanner.nextInt();
        scanner.nextLine();
        if (value == 1) {
            System.out.println("Enter a name of a item...");
            String item = scanner.nextLine();
            int index = groceryList.indexOf(item);
            if (index == -1) {
                System.out.println("Item doesn't exist");
            } else {
                System.out.println("Enter a name of new item");
                item = scanner.nextLine();
                groceryList.remove(index);
                groceryList.add(index,item);
                System.out.println("Item modified");
            }
        } else if (value == 2) {
            System.out.println("Enter a index of an item to modify");
            value = scanner.nextInt();
            scanner.nextLine();
            if (value > 0 && value -1 < groceryList.size()) {
                System.out.println("Enter a name of new item.");
                String val = scanner.nextLine();
                groceryList.remove(value-1);
                groceryList.add(value-1,val);
                System.out.println("Item modified");
            } else {
                System.out.println("Invalid index...!");
            }
        } else {
            System.out.println("Invalid choice...");
        }



    }

}
