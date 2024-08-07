package model;

import java.time.LocalDateTime;

public class ElectricBike extends Vehicle {
    private double rangePerCharge;

    public ElectricBike(String id, String manufacturer, String model, double purchasePrice, String description,
                        LocalDateTime purchaseDate, double rangePerCharge) {
        super(id, manufacturer, model, purchasePrice, description, purchaseDate);
        this.rangePerCharge = rangePerCharge;
    }

    public double getRangePerCharge() {
        return rangePerCharge;
    }

    public void setRangePerCharge(double rangePerCharge) {
        this.rangePerCharge = rangePerCharge;
    }
}
