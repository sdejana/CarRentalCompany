import model.Car;

import java.time.LocalDateTime;

public class Main
{
    public static void main(String[] args)
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        Car c1 = new Car("123Car", "Audi", "A4", 2000,
                "Used.", localDateTime, 5);
    System.out.print(c1);
    c1.chargeBattery(50);
    System.out.print(c1);
    }
}