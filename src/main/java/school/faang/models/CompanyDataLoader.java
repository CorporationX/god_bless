package school.faang.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDataLoader {
    public static List<EnvironmentalImpact> loadEnvironmentalImpacts(String filePath) throws IOException {
        List<EnvironmentalImpact> impacts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(", ");
                int id = Integer.parseInt(fields[0]);
                int companyId = Integer.parseInt(fields[1]);
                double volume = Double.parseDouble(fields[2]);
                LocalDate date = parseDate(fields[3]);
                EmissionType type = EmissionType.valueOf(fields[4].toUpperCase());

                EnvironmentalImpact impact = new EnvironmentalImpact(id, companyId, volume, date, type);
                impacts.add(impact);
            }
        }
        return impacts;
    }

    private static LocalDate parseDate(String dateString) {
        try {
            return LocalDate.parse(dateString);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + dateString, e);
        }
    }
}
