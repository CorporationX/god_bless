package faang.school.godbless.environmental_monitoring;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CompanyDataLoader {
    public List<EnvironmentalImpact> readDataFromCSV(String fileName) {
        try {
            return new CsvToBeanBuilder<EnvironmentalImpact>(new FileReader(fileName))
                    .withType(EnvironmentalImpact.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("File not found");
        }
    }
}