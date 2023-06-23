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
                new EnvironmentalImpact(1, 1, 15345.42, LocalDate.of(2023, 6, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(2, 1, 10009.79, LocalDate.of(2023, 5, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(3, 1, 8051.21, LocalDate.of(2023, 4, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(4, 1, 8116.80, LocalDate.of(2023, 3, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(5, 1, 12646.79, LocalDate.of(2023, 2, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(6, 1, 15733.36, LocalDate.of(2023, 1, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(7, 1, 9997.05, LocalDate.of(2022, 12, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(8, 1, 14385.51, LocalDate.of(2022, 11, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(9, 1, 12103.33, LocalDate.of(2022, 10, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(10, 1, 11603.40, LocalDate.of(2022, 9, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(11, 1, 13087.79, LocalDate.of(2022, 8, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(12, 1, 7108.54, LocalDate.of(2022, 7, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(13, 2, 15345.42, LocalDate.of(2023, 6, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(14, 2, 10009.79, LocalDate.of(2023, 5, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(15, 3, 8051.21, LocalDate.of(2023, 4, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(16, 2, 8116.80, LocalDate.of(2023, 3, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(17, 3, 12646.79, LocalDate.of(2023, 2, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(18, 2, 15733.36, LocalDate.of(2023, 1, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(19, 3, 9997.05, LocalDate.of(2022, 12, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(20, 2, 14385.51, LocalDate.of(2022, 11, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(21, 3, 12103.33, LocalDate.of(2022, 10, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(22, 2, 11603.40, LocalDate.of(2022, 9, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(23, 3, 13087.79, LocalDate.of(2022, 8, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(24, 2, 7108.54, LocalDate.of(2022, 7, 8), Type.ENERGY_CONSUMPTION)
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
