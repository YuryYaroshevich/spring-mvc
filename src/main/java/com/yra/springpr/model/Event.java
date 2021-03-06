package com.yra.springpr.model;

import java.io.Serializable;
import java.util.List;



public class Event implements Serializable {
    private static final long serialVersionUID = -793436798754046892L;
    private long id;
    private String name;
    private Rating rating;
    private double basePrice;
    
    private List<EventTimetable> timetable;
    
    public Event() {
    }

    public Event(String name, Rating rating, double basePrice) {
        this.name = name;
        this.rating = rating;
        this.basePrice = basePrice;
    }

    public Event(long id, String name, Rating rating, double basePrice) {
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.basePrice = basePrice;
	}
    
	public long getId() {
        return id;
    }
	
	public void setId(long id) {
        this.id = id;   
    }

    public String getName() {
        return name;
    }

    public Rating getRating() {
        return rating;
    }

    public double getBasePrice() {
        return basePrice;
    }
   
	public List<EventTimetable> getTimetable() {
        return timetable;
    }

    public void setTimetable(List<EventTimetable> timetable) {
        this.timetable = timetable;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(basePrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((rating == null) ? 0 : rating.hashCode());
        result = prime * result
                + ((timetable == null) ? 0 : timetable.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Event other = (Event) obj;
        if (Double.doubleToLongBits(basePrice) != Double
                .doubleToLongBits(other.basePrice))
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (rating != other.rating)
            return false;
        if (timetable == null) {
            if (other.timetable != null)
                return false;
        } else if (!timetable.equals(other.timetable))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", name=" + name + ", rating=" + rating
                + ", basePrice=" + basePrice + ", timetable=" + timetable + "]";
    }
}
