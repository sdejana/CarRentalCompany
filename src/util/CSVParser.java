package util;

import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static String parseCSVLine(String line) {
        String values = "";
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (char ch : line.toCharArray()) {
            if (ch == ',' && !inQuotes) {
                values += current.toString().trim() + " ";
                current.setLength(0);
            } else if (ch == '"') {
                inQuotes = !inQuotes;
            } else if (ch == '\\') {
                // Check if the next character is 'n' to detect "\n"
                if (current.length() > 0 && current.charAt(current.length() - 1) == 'n') {
                    System.out.println("Novi red.");
                    current.setLength(current.length() - 1); // Remove the 'n'
                }
            } else {
                current.append(ch);
            }
        }
        values += current.toString().trim() + " ";
        return values;
    }

    public static String[] getParameters(String line) {
        List<String> temp = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        for (char ch : line.toCharArray()) {
            if (ch != ' ') {
                current.append(ch); // Append character to current string
            } else {
                if (current.length() > 0) {
                    temp.add(current.toString()); // Add the current string to the list
                    current.setLength(0); // Reset the StringBuilder
                }
            }
        }

        // Add the last parameter (if any)
        if (current.length() > 0) {
            temp.add(current.toString());
        }

        // Convert List<String> to String[]
        return temp.toArray(new String[0]);
    }

    public static String parseCoordinates(String coordinates)
    {
        coordinates = parseCSVLine(coordinates);
        System.out.println(coordinates);
        return coordinates;
    }
}
