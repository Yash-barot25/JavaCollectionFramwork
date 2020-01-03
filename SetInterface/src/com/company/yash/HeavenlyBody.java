package com.company.yash;

import java.util.HashSet;
import java.util.Set;

public  class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satelites;

    @Override
    public int hashCode() {
        return this.name.hashCode() + 40;
    }

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satelites = new HashSet<>();

    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj || obj instanceof HeavenlyBody){
            return true;
        }

        System.out.println("class name " + this.getClass());
        System.out.println("Obj name " + obj.getClass());
        if (obj.getClass() != this.getClass()){
            return  false;
        }


        return ((HeavenlyBody) obj).getName().equals(this.name);

    }

    public void addmoon(HeavenlyBody moon) {
        this.satelites.add(moon);
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatelites() {
        return new HashSet<>(satelites);
    }
}
