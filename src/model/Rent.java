package model;

import util.PropertyLoader;

import javax.xml.stream.Location;
import java.time.Duration;
import java.time.LocalDateTime;

public class Rent
{
    private LocalDateTime dateTime;
    private User user;
    private String pickUpLocation;
    private String dropOffLocation;
    private long duration;
    private boolean amIForeigner = false;
    private static PropertyLoader rentalPrices = new PropertyLoader("resources/rentalPrices.properties");
    private static PropertyLoader factors = new PropertyLoader("resources/factors.properties");
    private LocalDateTime endTime;

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
    public void start (User user, String location, LocalDateTime time)
    {
        this.user = user;
        this.pickUpLocation = location;
        this.dateTime = time;
        this.dropOffLocation = null;
        this.endTime = null;
        this.duration = 0;
    }
    public void stop (User user, String location, LocalDateTime time)
    {
        this.user = user;
        this.dropOffLocation = location;
        this.endTime = time;

        this.duration = Duration.between(this.dateTime, this.endTime).getSeconds();
    }
    public void rent(User user, String pickUpLocation, String dropOffLocation,
                     LocalDateTime startTime, LocalDateTime endTime)
    {
        this.user = user;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.dateTime = startTime;
        this.endTime = endTime;

        this.duration = Duration.between(this.dateTime, this.endTime).getSeconds();
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isAmIForeigner() {
        return amIForeigner;
    }

    public void setAmIForeigner(boolean amIForeigner) {
        this.amIForeigner = amIForeigner;
    }
}
