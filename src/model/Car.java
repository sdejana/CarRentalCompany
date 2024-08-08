package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Car extends Vehicle
{
    private int passengerCapacity;

    public Car(String id, String manufacturer, String model, double purchasePrice, String description,
               LocalDateTime purchaseDate, int passengerCapacity)
    {
        super(id, manufacturer, model, purchasePrice, description, purchaseDate);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity()
    {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity)
    {
        this.passengerCapacity = passengerCapacity;
    }
    @Override
    public String toString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Car {" +
                "ID='" + getId() + '\n' +
                "Manufacturer='" + getManufacturer() + '\n' +
                "Model='" + getModel() + '\n' +
                "Purchase Price=" + getPurchasePrice() + '\n'+
                "Description='" + getDescription() + '\n' +
                "Purchase Date=" + getPurchaseDate().format(formatter) +
                '\n'+ "Passenger Capacity=" + passengerCapacity
                + '\n' + "Battery level: " + getCurrentBatteryLevel() +
                '}';
    }
}
