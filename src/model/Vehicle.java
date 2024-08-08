package model;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Vehicle
{
    private String id;
    private String manufacturer;
    private String model;
    private double purchasePrice;
    private double currentBatteryLevel;
    private String description;
    private LocalDateTime purchaseDate;
    private List<Malfunction> malfunctions;

    public Vehicle(String id, String manufacturer, String model, double purchasePrice, String description,
                   LocalDateTime purchaseDate, List<Malfunction> malfunctions)
    {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.purchasePrice = purchasePrice;
        this.description = description;
        this.purchaseDate = purchaseDate;
        this.malfunctions = malfunctions;
    }

    public Vehicle(String id, String manufacturer, String model, double purchasePrice,
                   String description, LocalDateTime purchaseDate)
    {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.purchasePrice = purchasePrice;
        this.description = description;
        this.purchaseDate = purchaseDate;
    }

    public String getId() { return id; }
    public String getManufacturer() { return manufacturer; }
    public String getModel() { return model; }
    public double getPurchasePrice() { return purchasePrice; }
    public double getCurrentBatteryLevel() { return currentBatteryLevel; }
    public String getDescription() { return description; }
    public LocalDateTime getPurchaseDate() { return purchaseDate; }

    public void setId(String id) { this.id = id; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public void setModel(String model) { this.model = model; }
    public void setPurchasePrice(double purchasePrice) { this.purchasePrice = purchasePrice; }
    public void setCurrentBatteryLevel(double currentBatteryLevel) { this.currentBatteryLevel = currentBatteryLevel; }
    public void setDescription(String description) { this.description = description; }
    public void setPurchaseDate(LocalDateTime purchaseDate) { this.purchaseDate = purchaseDate; }

    public void addMalfunction(String description, LocalDateTime dateTime)
    {
        this.malfunctions.add(new Malfunction(description, dateTime));
    }

    public void chargeBattery(double amount)
    {
        this.currentBatteryLevel = Math.min(100.0, this.currentBatteryLevel + amount);
    }

    public void useBattery(double amount)
    {
        this.currentBatteryLevel = Math.max(0.0, this.currentBatteryLevel - amount);
    }

    private class Malfunction
    {
        private String description;
        private LocalDateTime dateTime;

        private Malfunction(String description, LocalDateTime dateTime)
        {
            this.description = description;
            this.dateTime = dateTime;
        }

        public String getDescription()
        {
            return description;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        public LocalDateTime getDateTime()
        {
            return dateTime;
        }

        public void setDateTime(LocalDateTime dateTime)
        {
            this.dateTime = dateTime;
        }
    }
}
