package com.company.yash.Demo;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Raja");
        Labrador lab = new Labrador("Raja");

        System.out.println(dog.equals(lab));
        System.out.println(lab.equals(dog));


    }
}
