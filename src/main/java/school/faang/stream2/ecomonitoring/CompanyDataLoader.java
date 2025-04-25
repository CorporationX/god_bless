package school.faang.stream2.ecomonitoring;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CompanyDataLoader {

    public static List<EnvironmentalImpact> parseEnvImpactsCsv(File file) {
        try (CSVParser parser = CSVParser.parse(new FileReader(file),
                CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreSurroundingSpaces()
                        .withTrim())) {

            return parser.getRecords().stream()
                    .map(EnvironmentalImpact::fromCsvRecord)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении CSV-файла: " + e.getMessage(), e);
        }
    }
}
