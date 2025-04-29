package school.faang.stream2.ecomonitoring;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CompanyDataLoader {

    public static List<EnvironmentalImpact> parseEnvImpactsCsv(String fileName) {
        try (CSVParser parser = CSVParser.parse(new FileReader(fileName),
                CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setIgnoreSurroundingSpaces(true)
                        .setTrim(true)
                        .build())) {

            return parser.getRecords().stream()
                    .map(EnvironmentalImpact::fromCsvRecord)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            log.error("Ошибка при чтении CSV-файла: {}", e.getMessage());
            return Collections.emptyList();
        }
    }
}
