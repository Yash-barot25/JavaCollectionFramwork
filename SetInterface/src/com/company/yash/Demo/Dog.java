package com.company.yash.Demo;

public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public  final boolean equals(Object obj) {
        if (obj == this){
            return true;
        }

        if (obj instanceof Dog){
            String name = ((Dog)obj).getName();
            return this.name.equals(name);
        }
        return false;
    }
}
