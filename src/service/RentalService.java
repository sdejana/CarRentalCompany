package service;

import model.Rent;
import model.Vehicle;
import model.User;
import util.CSVParser;
import util.FileUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RentalService {
    private boolean hasPromotion;
    private final List<Rent> rentals;
     private final List<Vehicle> vehicles;

    public RentalService() {
        rentals = new ArrayList<>();
        vehicles = new ArrayList<>();
    }

    public void addRent(Rent rent) {
        this.rentals.add(rent);
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public List<Rent> getRentals() {
        return new ArrayList<>(rentals);
    }

    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    public Vehicle findVehicleById(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null; // or throw an exception if preferred
    }

    public List<Rent> getRentalsByUser(User user) {
        List<Rent> userRentals = new ArrayList<>();
        for (Rent rent : rentals) {
            if (rent.getUser().equals(user)) {
                userRentals.add(rent);
            }
        }
        return userRentals;
    }


    public boolean isHasPromotion() {
        return hasPromotion;
    }

    public void setHasPromotion(boolean hasPromotion) {
        this.hasPromotion = hasPromotion;
    }

    public void getVehicleData (String filepath) throws IOException
    {

        List<String> data = new ArrayList<>();
        data = FileUtil.getDataFromFile(filepath);
        data = FileUtil.sortDataByDateTime(data);

        List<String> validData = new ArrayList<>(data.size());

        int carNumber = 1;

        while (carNumber != data.size())
        {
            String temp = CSVParser.parseCSVLine(data.get(carNumber));
            String[] parameters = CSVParser.getParameters(temp);

            if (Arrays.stream(parameters).count() < 9)
            {
                System.out.println("Not enough parameters!");
                carNumber++;
            } else if (Arrays.stream(parameters).count() > 9)
            {
                System.out.println("Too many parameters! ");
                carNumber++;
            }


            carNumber++;
        }
    }
    // Method to check if a string is a valid date in the format "dd.MM.yyyy"
    public static boolean isValidDate(String date) {
        String datePattern = "\\d{1,2}\\.\\d{1,2}\\.\\d{4}";
        return date.matches(datePattern);
    }

    // Method to check if a string is a valid time in the format "HH:mm"
    public static boolean isValidTime(String time) {
        String timePattern = "\\d{1,2}:\\d{2}";
        return time.matches(timePattern);
    }

    // Method to check if a string has valid coordinates [e.g. 1,2 & 19,8]
    public static boolean isValidCoordinates(String coordinatesPickUp, String coordinatesDropOff) {
        coordinatesPickUp = CSVParser.parseCoordinates(coordinatesPickUp);
        coordinatesDropOff = CSVParser.parseCoordinates(coordinatesDropOff);

        // Validate both pickup and dropoff coordinates simultaneously
        return checkCoordinate(coordinatesPickUp) && checkCoordinate(coordinatesDropOff);
    }

    // Method to check if a string value is in 0-19 range
    private static boolean checkCoordinate(String coordinate) {

        String[] parts = coordinate.split(" ");
        if (parts.length != 2) {
            System.out.println("Invalid coordinate format.");
            return false; // Invalid coordinate format
        }

        try {
            int x = Integer.parseInt(parts[0].trim());
            int y = Integer.parseInt(parts[1].trim());
            // Check if both x and y are within the range 0 to 19
            if (x >= 0 && x <= 19 && y >= 0 && y <= 19) {
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Not a valid number.");
            return false; // Not a valid number
        }
        System.out.println("Out of bounds or invalid format.");
        return false; // Out of bounds or invalid format
    }

}
