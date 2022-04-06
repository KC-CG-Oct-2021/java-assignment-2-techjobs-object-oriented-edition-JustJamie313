package org.launchcode.techjobs.oo;

import java.util.Objects;

public class PositionType {
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
    public PositionType() {
        id = nextId;
        nextId++;
    }

    public PositionType(String value) {
        this();
        this.value = value;
    }
    @Override
    public String toString(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionType that = (PositionType) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }





}
