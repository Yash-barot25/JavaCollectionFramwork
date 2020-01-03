package com.company.yash;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        List<String> myList = new LinkedList<>();
        arrangeList(myList,"Brampton");
        arrangeList(myList,"Ajax");
        arrangeList(myList,"Oakville");
        arrangeList(myList,"Winnipeg");
        arrangeList(myList,"Abu");
        arrangeList(myList,"Zohn");
        arrangeList(myList,"Code");

        arrangeList(myList,"Code");
        arrangeList(myList,"British");
        printList(myList);
//        myList.add("toronto");
//        myList.add("brampton");
//        myList.add("mississauga");
//        myList.add("oakville");

//        for (int i = 0; i < myList.size();i++){
////            System.out.println(myList.get(i));
////        }
////        System.out.println("\n============\n");
////        myList.add(1,"scarbrough");
////        for (int i = 0; i < myList.size();i++){
////            System.out.println(myList.get(i));
////        }
////        System.out.println("\n============\n");
////        myList.remove(myList.size()-1);
////        for (int i = 0; i < myList.size();i++){
////            System.out.println(myList.get(i));
////        }
////        myList.set(1,"oakville");
////        System.out.println("\n============\n");
////
////        for (int i = 0; i < myList.size();i++){
////            System.out.println(myList.get(i));
////        }

    }


    private static void printList(List<String> list){
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            System.out.println("Cities..." + iter.next());
        }
    }

    private static boolean  arrangeList(List<String> list,String city){
        ListIterator<String> iter = list.listIterator();
        while(iter.hasNext()){

            int comparision = iter.next().compareTo(city);
            if (comparision == 0){
                System.out.println(city + " Already exist.");
                return  false;
            }else if(comparision > 0){
                iter.previous();
                iter.add(city);
                return  true;
            }else{

            }
        }
        iter.add(city);
        return false;
    }

}
