import model.Car;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        Car c1 = new Car("123Car", "Audi", "A4", 2000,
                "Polovan.", localDateTime, 5);
    System.out.print(c1);
    c1.chargeBattery(50);
    System.out.print(c1);
    }
}