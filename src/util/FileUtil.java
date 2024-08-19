package util;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;

public class FileUtil
{
    public void saveToFile(String filepath, String data)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath)))
        {
            writer.write(data);
        } catch (IOException e)
        {
            System.out.println("An error occurred while saving data to file: " + e.getMessage());
        }
    }

    public String readFromFile(String filepath)
    {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                content.append(line).append("\n");
            }
        } catch (IOException e)
        {
            System.out.println("An error occurred while reading data from file: " + e.getMessage());
        }

        return content.toString();
    }

    public String sortDataByDateTime(String data) {

            String[] lines = data.split("\n");

            // Check if there's at least one line
            if (lines.length <= 1) {
                return data; // If there's only one line, return it as is (nothing to sort)
            }

            // Extract the header (first line)
            String header = lines[0];

            // Extract the data lines (excluding the header)
            String[] dataLines = Arrays.copyOfRange(lines, 1, lines.length);

            // Define the date-time format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy HH:mm");

            // Sort the data lines by date and time
            Arrays.sort(dataLines, Comparator.comparing(line -> {
                String[] parts = line.split(",", 2); // Split at the first comma
                LocalDateTime dateTime = LocalDateTime.parse(parts[0], formatter);
                return dateTime;
            }));

            // Combine the header with the sorted data lines
            return header + "\n" + String.join("\n", dataLines);
        }
}
