package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {
    //fields
    private int id;
    private static int nextId = 1;
    private static final String DEFAULT_MESSAGE = "Data not available";

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    //getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Employer getEmployer() {
        return employer;
    }
    public Location getLocation() {
        return location;
    }
    public PositionType getPositionType() {
        return positionType;
    }
    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }
    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    //constructors
    public Job(){
        id = nextId;
        nextId++;
    }
    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency){
        this();
        name = aName;
        employer = aEmployer;
        location = aLocation;
        positionType = aPositionType;
        coreCompetency = aCoreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String value = "";
        if((getName() == null || getName() == "") && getEmployer() == null && getLocation() == null && getPositionType() == null && getCoreCompetency() == null){
            return "\nOOPS! This job does not seem to exist.\n";
        }

        value =  String.format("\n" +
                        "ID: %s\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n",
                id == 0? DEFAULT_MESSAGE : id,
                getValueFromField(name),
                getValueFromField(employer),
                getValueFromField(location),
                getValueFromField(positionType),
                getValueFromField(coreCompetency));

        return value;
    }
    public String getValueFromField(JobField field){
        if(field == null || field.getValue() == "" ) field.setValue(DEFAULT_MESSAGE);
        return field.getValue();
    }
    public String getValueFromField(String name){
        if(name == null || name == "") name = DEFAULT_MESSAGE;
        return name;
    }
}
