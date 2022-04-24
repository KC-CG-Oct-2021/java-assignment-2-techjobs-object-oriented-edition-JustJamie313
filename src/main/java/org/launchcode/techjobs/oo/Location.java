package org.launchcode.techjobs.oo;

public class Location extends JobField{
    public Location(String aLocation){
        super(aLocation);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getId() == location.getId();
    }
}
