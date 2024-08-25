import exceptions.FileException;
import model.Car;
import model.DomesticUser;
import model.ForeignUser;
import service.VehicleService;
import util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws FileException, IOException {
       /* LocalDateTime localDateTime = LocalDateTime.now();
        Car c1 = new Car("123Car", "Audi", "A4", 2000,
                "Used.", localDateTime, 5);
        System.out.print(c1);
        c1.chargeBattery(50);
        System.out.print(c1);
        DomesticUser domesticUser = new DomesticUser("dejana");
        ForeignUser foreignUser = new ForeignUser("maria");
        System.out.println();
        domesticUser.print();`
        foreignUser.print();
        */
        VehicleService vehicleService = new VehicleService();
        //vehicleService.getVehicleData(FileUtil.getTestDataPath());
       // System.out.println(vehicleService);
    }
}
