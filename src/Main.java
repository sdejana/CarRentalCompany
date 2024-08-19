import exceptions.FileException;
import model.Car;
import model.DomesticUser;
import model.ForeignUser;
import util.FileUtil;

import java.time.LocalDateTime;

public class Main
{
    public static void main(String[] args) throws FileException {
        LocalDateTime localDateTime = LocalDateTime.now();
        Car c1 = new Car("123Car", "Audi", "A4", 2000,
                "Used.", localDateTime, 5);
        System.out.print(c1);
        c1.chargeBattery(50);
        System.out.print(c1);
        DomesticUser domesticUser = new DomesticUser("dejana");
        ForeignUser foreignUser = new ForeignUser("maria");
        System.out.println();
        domesticUser.print();
        foreignUser.print();
        FileUtil fileUtil = new FileUtil();
        String read = fileUtil.readFromFile("src/model/PJ2 - projektni zadatak 2024 - Iznajmljivanja (3).csv");
        System.out.println(read);
        fileUtil.saveToFile("src/model/testni.txt", "Upisujem testne podatke.");
        read = fileUtil.sortDataByDateTime(read);
        System.out.println("Sortirano" + read);
    }
}
