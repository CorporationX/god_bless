package EkologyMonitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CompanyDataLoader {
    public List<EnvironmentalImpact> loadFromCSV(String filePath) {
        List<EnvironmentalImpact> impacts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Пропускаем первую строку, так как это заголовок
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                int companyId = Integer.parseInt(values[1]);
                double volume = Double.parseDouble(values[2]);
                LocalDate date = LocalDate.parse(values[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                EnvironmentalImpact.ImpactType type = EnvironmentalImpact.ImpactType.valueOf(values[4]);

                impacts.add(new EnvironmentalImpact(id, companyId, volume, date, type));
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            e.printStackTrace();
        }

        return impacts;
    }
}