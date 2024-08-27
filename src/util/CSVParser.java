package util;

import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    /*
    public static String parseCSVLine(String line) {
        String values = "";
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        int blankSpace = 0;

        for (char ch : line.toCharArray()) {
            if (ch == ',' && !inQuotes) {
                values += current.toString().trim() + ' ';
                current.setLength(0);
            } else if (ch == '"') {
                inQuotes = !inQuotes;
            } else if (ch == '\\') {
                // Check if the next character is 'n' to detect "\n"
                if (current.length() > 0 && current.charAt(current.length() - 1) == 'n') {
                    current.setLength(current.length() - 1); // Remove the 'n'
                }
            } else {
                current.append(ch);
            }

        }
        values += current.toString().trim();
        return values;
    }
*/
    public static String parseCSVLine(String line) {
        StringBuilder values = new StringBuilder();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == ',' && !inQuotes) {
                // Add current value or 'null' if empty
                if (current.length() == 0) {
                    values.append("#");
                } else {
                    values.append(current.toString().trim());
                }
                values.append("  ");
                current.setLength(0);

                // Check if the next character is a comma (indicating an empty value)
               /* if (i + 1 < line.length() && line.charAt(i + 1) == ',' && line.charAt(i) == ',')
                {
                    System.out.println("yes");
                }
                */
            } else if (ch == '"') {
                inQuotes = !inQuotes;
            } else {
                current.append(ch);
            }
        }

        // Handle the last value or 'null' if empty
        if (current.length() == 0) {
            values.append("null");
        } else {
            values.append(current.toString().trim());
        }

        return values.toString();
    }


    /*public static String[] getParameters(String line) {
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
*/
    public static String parseCoordinates(String coordinates)
    {
        coordinates = parseCSVLine(coordinates);
        return coordinates;
    }
    public static String[] getParameters(String line) {
        List<String> temp = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            // Detect two spaces as a delimiter
            if (ch == ' ' && i + 1 < line.length() && line.charAt(i + 1) == ' ') {
                if (current.length() > 0) {
                    temp.add(current.toString());
                    current.setLength(0);
                }
                i++; // Skip the next space
            } else {
                current.append(ch);
            }
        }

        // Add the last parameter (if any)
        if (current.length() > 0) {
            temp.add(current.toString());
        }

        return temp.toArray(new String[0]);
    }
}
