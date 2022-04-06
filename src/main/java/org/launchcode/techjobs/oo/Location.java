package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Location {
    //fields
    private int id;
    private static int nextId = 1;
    private String value;

    //getters
    public int getId() {
        return id;
    }
    public String getValue() {
        return value;
    }

    //setters
    public void setValue(String value) {
        this.value = value;
    }

    //constructors
    public Location() {
        id = nextId;
        nextId++;
    }
    public Location(String aLocation){
        this();
        this.value = aLocation;
    }

    // Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getId() == location.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Getters and Setters:





}
