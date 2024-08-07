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


    /**
     * TODO: implement Malfunction class.
     */
    private class Malfunction
    {}
}
