package com.company.yash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {

        HeavenlyBody planet = new HeavenlyBody("Earth", 22.00);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        HeavenlyBody moon = new HeavenlyBody("Moon", 17.36);
        solarSystem.put(moon.getName(), moon);
        planet.addmoon(moon);

        planet = new HeavenlyBody("Jupiter", 26.50);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        moon = new HeavenlyBody("Sinope", 19.66);
        solarSystem.put(moon.getName(), moon);
        planet.addmoon(moon);

        moon = new HeavenlyBody("Elara", 11.23);
        solarSystem.put(moon.getName(), moon);
        planet.addmoon(moon);

        planet = new HeavenlyBody("Saturn", 32.26);
        solarSystem.put(planet.getName(), planet);
        planets.add(planet);

        moon = new HeavenlyBody("Titan", 36.25);
        solarSystem.put(moon.getName(), moon);
        planet.addmoon(moon);


        System.out.println("All solar system members:- ");
        for (HeavenlyBody body : solarSystem.values()) {
            System.out.println("\t- " + body.getName());
        }

        System.out.println("Planets: ");
        for (HeavenlyBody body : planets) {
            System.out.println("\t" + body.getName());
            body = solarSystem.get(body.getName());
            for (HeavenlyBody bodyMap : body.getSatelites()) {
                System.out.println("\t\t- " + bodyMap.getName());
            }


        }

        Set<HeavenlyBody> membersUnion = new HashSet<>();
        for (HeavenlyBody body: planets){
            membersUnion.addAll(body.getSatelites());
        }

        for (HeavenlyBody body: membersUnion){
            System.out.println("-"+body.getName());
        }
        System.out.println("=====================");
        HeavenlyBody earth = new HeavenlyBody("Earth", 2.33);
        planets.add(earth);
        for (HeavenlyBody body: planets){
            System.out.println(body.getName());
        }
//        System.out.println("=====================");
//        test star = new test("Earth", 23.00);
//        planets.add(star);
//        star = new test("Jupiter", 23.00);
//        planets.add(star);
//        for (HeavenlyBody body: planets){
//            System.out.println(body.getName());
//        }


    }
}