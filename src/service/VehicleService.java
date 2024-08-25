package service;

import model.Vehicle;
import util.FileUtil;
import util.CSVParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class VehicleService
{
    private List<Vehicle> vehicles;

    public void getVehiclesData (String filepath)
    {

    }
    //Check if vehicle already exists.
    private boolean isDuplicate(String id)
    {
        for(Vehicle vehicle1 : vehicles)
        {
            if(Objects.equals(vehicle1.getId(), id))
            {
                System.out.println("Vehicle with this ID already exists!");
                return true;
            }
        }
        return false;
    }



}
