package model;

import java.time.LocalDateTime;

public class Car extends Vehicle
{
    private int passengerCapacity;

    public Car(String id, String manufacturer, String model, double purchasePrice, String description,
               LocalDateTime purchaseDate, int passengerCapacity) {
        super(id, manufacturer, model, purchasePrice, description, purchaseDate);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
