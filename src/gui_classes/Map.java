package gui_classes;

import model.Vehicle;

public class Map
{
    private static int numberOfFields = 20;
    public Vehicle[][] vehicles = new Vehicle[getNumberOfFields()][getNumberOfFields()];

    public static int getNumberOfFields()
    {
        return numberOfFields;
    }

    public static void setNumberOfFields(int numberOfFields)
    {
        Map.numberOfFields = numberOfFields;
    }
}
