package faang.school.godbless.eco_monitoring;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CompanyDataLoader {
    private final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public List<EnvironmentalImpact> loadData(String pathToCompanyDateCsv) {
        List<EnvironmentalImpact> environmentalImpactList = new ArrayList<>();

        try (Scanner companyDateScanner = new Scanner(new File(pathToCompanyDateCsv))) {
            companyDateScanner.useDelimiter("(, )|(,)|(\n)");

            while (companyDateScanner.hasNextLine()) {
                try {
                    int id = companyDateScanner.nextInt();
                    int companyId = companyDateScanner.nextInt();
                    double impactVolume = Double.parseDouble(companyDateScanner.next());
                    LocalDate impactDate = LocalDate.parse(companyDateScanner.next(), DATE_FORMAT);
                    EnvironmentalImpactType impactType = EnvironmentalImpactType.valueOf(companyDateScanner.next().trim());

                    EnvironmentalImpact environmentalImpact = new EnvironmentalImpact(id, companyId, impactVolume,
                            impactDate, impactType);

                    environmentalImpactList.add(environmentalImpact);
                } catch (DateTimeParseException exception) {
                    throw new RuntimeException("Could not process date format in csv format " + exception.getMessage());
                }
            }
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("Could not find company date csv " + exception.getMessage());
        } catch (InputMismatchException exception) {
            throw new RuntimeException("Parse values " + exception.getMessage());
        }

        return environmentalImpactList;
    }
}
