package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

class CompanyDataLoader {
    public List<EnvironmentalImpact> loadEnvironmentalImpacts(String fileName) {
        List<EnvironmentalImpact> impacts = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            impacts = reader.lines()
                    .skip(1)
                    .map(line -> {
                        String[] values = line.split(",");
                        int companyId = Integer.parseInt(values[1].trim());
                        String companyName = values[2].trim();
                        int employees = Integer.parseInt(values[3].trim());
                        double volume = Double.parseDouble(values[4].trim());
                        LocalDate date = LocalDate.parse(values[5].trim());
                        EnvironmentalImpactType type = EnvironmentalImpactType.valueOf(values[6].trim());
                        return new EnvironmentalImpact(companyId, companyName, employees, volume, date, type);
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return impacts;
    }
}