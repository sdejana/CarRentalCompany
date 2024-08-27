package model;

import java.time.LocalDateTime;

public class ElectricScooter extends Vehicle
{
    private double maxSpeed;

    public ElectricScooter(String id, String manufacturer, String model, double purchasePrice, String description,
                           LocalDateTime purchaseDate, double maxSpeed)
    {
        super(id, manufacturer, model, purchasePrice, description, purchaseDate);
        this.maxSpeed = maxSpeed;
    }
    public ElectricScooter(String id)
    {
        super(id);
    }
    public double getMaxSpeed()
    {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed)
    {
        this.maxSpeed = maxSpeed;
    }
}
