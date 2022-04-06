package org.launchcode.techjobs.oo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

        try {
            value =  String.format("\n" +
                            "ID: %s\n" +
                            "Name: %s\n" +
                            "Employer: %s\n" +
                            "Location: %s\n" +
                            "Position Type: %s\n" +
                            "Core Competency: %s\n",
                    id == 0? DEFAULT_MESSAGE : id,
                    getValueFromField("Name",true),
                    getValueFromField("Employer",true),
                    getValueFromField("Location",true),
                    getValueFromField("PositionType",true),
                    getValueFromField("CoreCompetency",true));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return value;
    }
    public String getValueFromField(String fieldName, Boolean substituteEmpty) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        String className = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        String getterName = "get" + className;
        Method getter = getClass().getMethod(getterName);
        String value;

        if (className.equals("Name")) {
            value = (String) getter.invoke(this);
        } else {
            Class clazz = getClassByName(className);
            Method getValueMethod = clazz.getMethod("getValue");
            value = (String) getValueMethod.invoke(getter.invoke(this));
        }
        if (substituteEmpty && value == "") {
            value = "Data not available";
        }
        return value;
    }
    public Class getClassByName(String className) throws ClassNotFoundException {
        return Class.forName("org.launchcode.techjobs.oo." + className);
    }
}
