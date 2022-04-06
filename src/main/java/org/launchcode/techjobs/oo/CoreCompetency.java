package org.launchcode.techjobs.oo;

import java.util.Objects;

public class CoreCompetency {
    //fields
    private int id;
    private static int nextId = 1;
    private String value;

    //getters
    public String getValue() {
        return value;
    }
    public int getId() {
        return id;
    }

    //setters
    public void setValue(String value) {
        this.value = value;
    }

    //Constructors
    public CoreCompetency() {
        this.id = nextId;
        nextId++;
    }
    public CoreCompetency(String value) {
        this();
        this.value = value;
    }

    // Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoreCompetency)) return false;
        CoreCompetency that = (CoreCompetency) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
