package com.company.yash.Normal;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final String description;
    private final int direction;
    private final Map<String, Integer> exits;

    public Location(int direction, String description) {
        this.description = description;
        this.direction = direction;
        exits = new HashMap<>();
    }

    public void addExit(String desc, Integer dir) {
        exits.put(desc, dir);
    }

    public String getDescription() {
        return description;
    }

    public int getDirection() {
        return direction;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }
}
