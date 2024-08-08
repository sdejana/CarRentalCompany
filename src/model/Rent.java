package model;

import util.PropertyLoader;

import java.time.LocalDateTime;

public class Rent
{
    private LocalDateTime dateTime;
    private User user;
    private String pickUpLocation;
    private String dropOffLocation;
    private long duration;
    private static PropertyLoader rentalPrices = new PropertyLoader("resources/rentalPrices.properties");
    private static PropertyLoader factors = new PropertyLoader("resources/factors.properties");

    public Rent(LocalDateTime dateTime, User user, String pickUpLocation, String dropOffLocation, long duration)
    {
        this.dateTime = dateTime;
        this.user = user;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.duration = duration;
    }

    public LocalDateTime getDateTime()
    {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime)
    {
        this.dateTime = dateTime;
    }

    public String getPickUpLocation()
    {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation)
    {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropOffLocation()
    {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation)
    {
        this.dropOffLocation = dropOffLocation;
    }

    public long getDuration()
    {
        return duration;
    }

    public void setDuration(long duration)
    {
        this.duration = duration;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public void generateTotalPrice ()
    {}
}
