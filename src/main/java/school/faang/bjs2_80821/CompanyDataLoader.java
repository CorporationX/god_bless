package school.faang.bjs2_80821;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CompanyDataLoader {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");


    public List<EnvironmentalImpact> parseEnvImpactFile(String path) {
        List<EnvironmentalImpact> result = new ArrayList<>();


        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                if (filter(nextLine)) {
                    EnvironmentalImpact envImpactObj = new EnvironmentalImpact(
                            Integer.parseInt(nextLine[0]),
                            Integer.parseInt(nextLine[1]),
                            Double.parseDouble(nextLine[2]),
                            LocalDate.parse(nextLine[3], formatter),
                            ExposureType.valueOf(nextLine[4])
                    );
                    result.add(envImpactObj);
                }
            }
            return result;
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean filter(String[] line) {
        if (
                line[0].chars().allMatch(Character::isDigit)
        ) {
            return true;
        }
        return false;
    }
}
