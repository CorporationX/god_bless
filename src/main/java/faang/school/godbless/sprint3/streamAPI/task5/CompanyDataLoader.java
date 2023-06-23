package faang.school.godbless.sprint3.streamAPI.task5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CompanyDataLoader {

    public void writeCSV(List<EnvironmentalImpact> environmentalImpacts, String pathToCSV) {
        try (FileWriter csvWriter = new FileWriter(pathToCSV)) {
            csvWriter.append("Id");
            csvWriter.append(",");
            csvWriter.append("company_id");
            csvWriter.append(",");
            csvWriter.append("volume");
            csvWriter.append(",");
            csvWriter.append("date");
            csvWriter.append(",");
            csvWriter.append("type");
            csvWriter.append("\n");
            for (EnvironmentalImpact environmentalImpact : environmentalImpacts) {
                csvWriter.append(String.valueOf(environmentalImpact.getId()));
                csvWriter.append(",");
                csvWriter.append(String.valueOf(environmentalImpact.getCompanyId()));
                csvWriter.append(",");
                csvWriter.append(String.valueOf(environmentalImpact.getVolume()));
                csvWriter.append(",");
                csvWriter.append(environmentalImpact.getDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));
                csvWriter.append(",");
                csvWriter.append(environmentalImpact.getType().toString());
                csvWriter.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<EnvironmentalImpact> environmentalImpacts = List.of(
                new EnvironmentalImpact(1, 2, 3.4, LocalDate.of(2023, 1, 8), Type.GAS_EMISSION),
                new EnvironmentalImpact(2, 1, 3.4, LocalDate.of(2023, 5, 15), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(3, 1, 2.4, LocalDate.of(2023, 6, 10), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(4, 2, 6.4, LocalDate.of(2023, 3, 6), Type.GAS_EMISSION),
                new EnvironmentalImpact(5, 1, 10.4, LocalDate.of(2023, 4, 24), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(6, 3, 10.4, LocalDate.of(2023, 3, 13), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(7, 3, 16.8, LocalDate.of(2023, 4, 30), Type.GAS_EMISSION),
                new EnvironmentalImpact(8, 3, 1.4, LocalDate.of(2023, 5, 1), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(9, 3, 12.5, LocalDate.of(2023, 6, 12), Type.GAS_EMISSION)
        );
        CompanyDataLoader companyDataLoader = new CompanyDataLoader();
        companyDataLoader.writeCSV(environmentalImpacts, "new.csv");

        List<EnvironmentalImpact> environmentalImpacts1 = companyDataLoader.readCSV("new.csv");
        environmentalImpacts1.forEach(System.out::println);
    }

    public List<EnvironmentalImpact> readCSV(String pathToCSV) {
        List<EnvironmentalImpact> environmentalImpacts = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(pathToCSV))) {
            String row;
            boolean skipFirstLine = true;
            while ((row = csvReader.readLine()) != null) {
                if (skipFirstLine) {
                    skipFirstLine = false;
                } else {
                    String[] data = row.split(",");
                    EnvironmentalImpact environmentalImpact = getEnvironmentalImpact(data);
                    environmentalImpacts.add(environmentalImpact);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return environmentalImpacts;
    }

    private EnvironmentalImpact getEnvironmentalImpact(String[] data) {
        return new EnvironmentalImpact(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Double.parseDouble(data[2]),
                LocalDate.of(
                        Integer.parseInt(data[3].split("\\.")[0]),
                        Integer.parseInt(data[3].split("\\.")[1]),
                        Integer.parseInt(data[3].split("\\.")[2])
                )
                , Type.valueOf(data[4])
        );
    }
}
