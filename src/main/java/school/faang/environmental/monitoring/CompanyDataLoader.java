package school.faang.environmental.monitoring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CompanyDataLoader {

    public static List<EnvironmentalImpact> csvToEnvironmentalImpacts(String filePath) throws IOException {
        List<EnvironmentalImpact> impacts = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        Path csvPath = Paths.get(filePath);
        try (Stream<String> lines = Files.lines(csvPath)) {
            lines.skip(1)
                    .forEach(line -> {
                        String[] values = line.split(",");
                        EnvironmentalImpact impact = new EnvironmentalImpact(
                                Integer.parseInt(values[0]),
                                Integer.parseInt(values[1]),
                                Double.parseDouble(values[2]),
                                LocalDate.parse(values[3], formatter),
                                EmissionType.valueOf(values[4])
                        );
                        impacts.add(impact);
                    });
        }
        return impacts;
    }
}
