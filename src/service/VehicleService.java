package service;

import model.Car;
import model.ElectricBike;
import model.ElectricScooter;
import model.Vehicle;
import util.FileUtil;
import util.CSVParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class VehicleService
{
    private List<Vehicle> vehicles = new ArrayList<>();

    public void getVehiclesData (String filepath) throws IOException
    {
        List<String> data = new ArrayList<>();
        data = FileUtil.getDataFromFile(filepath);
        int carNumber = 1;

        while (carNumber < data.size())
        {
            String temp = CSVParser.parseCSVLine(data.get(carNumber));
            String[] parameters = CSVParser.getParameters(temp);

            /*
             * parameters[0] => ID
             * parameters[1] => Proizvodjac
             * parameters[2] => Model
             * parameters[3] => Datum nabavke
             * parameters[4] => Cijena
             * parameters[5] => Domet
             * parameters[6] => Max brzina
             * parameters[7] => Opis
             * parameters[8] => Vrsta automobila
             * if parameters[x] equals #, missing parameter -> default value
            */

            if (Arrays.stream(parameters).count() < 9)
            {
                System.out.println("Not enough parameters!");
                carNumber++;
                continue;
            } else if (Arrays.stream(parameters).count() > 9)
            {
                System.out.println("Too many parameters! ");
                carNumber++;
                continue;
            }
            if(Objects.equals(parameters[0], "#") || Objects.equals(parameters[8], "#"))
            {
                System.out.println("Vehicle doesn't have enough parameters!");
            }
            else
            {
                setDefaultParameters(parameters);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDateTime localDateTime = LocalDateTime.parse(parameters[3], formatter);

                if (Objects.equals(parameters[8], "automobil"))
                {
                    Random random = new Random();
                    int passengerCapacity = random.nextInt(8) + 2;

                    Vehicle vehicle = new Car(parameters[0], parameters[1], parameters[2], Double.parseDouble(parameters[4]),
                            parameters[7], localDateTime, passengerCapacity);
                    vehicles.add(vehicle);

                } else if (Objects.equals(parameters[8], "trotinet"))
                {
                    Vehicle vehicle = new ElectricScooter(parameters[0]);
                    vehicles.add(vehicle);
                } else if (Objects.equals(parameters[8], "bicikl"))
                {
                    Vehicle vehicle = new ElectricBike(parameters[0]);
                    vehicles.add(vehicle);
                }
                carNumber++;
            }
        }
    }

    //Check if vehicle already exists.
    private boolean isDuplicate(String id) {
        if(vehicles == null)
        {
            return false;
        }
        else {
            for (Vehicle vehicle1 : vehicles) {
                if (Objects.equals(vehicle1.getId(), id)) {
                    System.out.println("Vehicle with this ID already exists!");
                    return true;
                }
            }
            return false;
        }
    }
    public void setDefaultParameters(String[] parameters)
    {
        if(Objects.equals(parameters[1], "#"))
        {
            parameters[1] = "Unknown manufacturer.";
        }
        if(Objects.equals(parameters[2], "#"))
        {
            parameters[2] = "Unknown model.";
        }
        if(Objects.equals(parameters[3], "#"))
        {
            LocalDate startDate = LocalDate.of(2015, 1, 1);
            LocalDate endDate = LocalDate.of(2024, 12, 31);
            parameters[3] = String.valueOf(getRandomDate(startDate, endDate));
        }
        if(Objects.equals(parameters[4], "#"))
        {
            parameters[4] = "0";
        }
        if(Objects.equals(parameters[5], "#"))
        {
            parameters[5] = "0";
        }
        if(Objects.equals(parameters[6], "#"))
        {
            parameters[6] = "0";
        }
        if(Objects.equals(parameters[7], "#"))
        {
            parameters[7] = "No data.";
        }

    }

    public static LocalDate getRandomDate(LocalDate startDate, LocalDate endDate) {
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        long randomDays = ThreadLocalRandom.current().nextLong(0, daysBetween + 1);
        return startDate.plusDays(randomDays);
    }

}

