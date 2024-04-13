package faang.school.godbless.bjs2_5257;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CompanyDataLoader {

    public static List<EnvironmentalImpact> readCsvToListEnvImpacts(String fileName) {
        List<EnvironmentalImpact> environmentalImpactList = new ArrayList<>();
        try {
            environmentalImpactList = new CsvToBeanBuilder<EnvironmentalImpact>(new FileReader(fileName))
                    .withType(EnvironmentalImpact.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException exception) {
            log.error("File not found");
        }
        return environmentalImpactList;
    }
}
