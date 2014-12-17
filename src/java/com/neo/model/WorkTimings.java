package com.neo.model;

/**
 *
 * @author neo
 */
public class WorkTimings {
    private String day;
    private int estimated;
    private int actual;

    public WorkTimings(String day, int estimated, int actual) {
        this.day = day;
        this.estimated = estimated;
        this.actual = actual;
    }

    public WorkTimings() {
       
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getEstimated() {
        return estimated;
    }

    public void setEstimated(int estimated) {
        this.estimated = estimated;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }
    
    
    
}
