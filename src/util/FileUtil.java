package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileUtil
{
    private static final String testDataPath = "resources" + File.separator + "data" + File.separator
            + "PJ2 - projektni zadatak 2024 - Iznajmljivanja.csv";

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

    public static List<String> sortDataByDateTime(List<String> data) {
        // Check if there's at least one data line
        if (data.size() <= 1) {
            return data; // If there's only one line or no data, return as is (nothing to sort)
        }

        // Extract the header (first line)
        String header = data.get(0);

        // Extract the data lines (excluding the header)
        List<String> dataLines = data.subList(1, data.size());

        // Define the date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy HH:mm");

        // Sort the data lines by date and time
        Collections.sort(dataLines, Comparator.comparing(line -> {
            String[] parts = line.split(",", 2); // Split at the first comma
            LocalDateTime dateTime = LocalDateTime.parse(parts[0], formatter);
            return dateTime;
        }));

        // Add the header back to the sorted data lines
        dataLines.add(0, header);

        return dataLines;
    }

    public static String getTestDataPath()
    {
        return testDataPath;
    }


    /**
     * Reads vehicle data from a file, processes it line by line,
     * and parses the CSV content.
     *
     * @param filepath The path to the file containing vehicle data.
     * @throws IOException if there is an issue reading the file.
     */
    public static List<String> getDataFromFile(String filepath) throws IOException
    {
        return Files.readAllLines(Paths.get(filepath));
    }
}

