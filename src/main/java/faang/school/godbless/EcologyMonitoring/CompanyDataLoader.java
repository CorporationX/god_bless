package faang.school.godbless.EcologyMonitoring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CompanyDataLoader {
    public List<EnvironmentalImpact> readCSVFile(File file) {
        List<EnvironmentalImpact> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            data = reader.lines()
                    .skip(1)
                    .map(this::readCSVLine)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    private EnvironmentalImpact readCSVLine(String line) {
        String[] fields = line.split(",");
        try {
            return EnvironmentalImpact.builder()
                    .id(Integer.parseInt(fields[0]))
                    .companyId(Integer.parseInt(fields[1]))
                    .companyName(fields[2])
                    .volume(Double.parseDouble(fields[3]))
                    .date(LocalDate.parse(fields[4]))
                    .type(ImpactType.valueOf(fields[5]))
                    .build();
        } catch (Exception e) {
            return null;
        }
    }
}
