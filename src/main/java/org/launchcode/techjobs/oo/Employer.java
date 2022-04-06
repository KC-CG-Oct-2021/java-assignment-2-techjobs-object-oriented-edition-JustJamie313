package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Employer {
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
    public Employer() {
        id = nextId;
        nextId++;
    }
    public Employer(String value) {
        this();
        this.value = value;
    }

    // Custom toString, equals, and hashCode methods:
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        Employer employer = (Employer) o;
        return getId() == employer.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }





}
