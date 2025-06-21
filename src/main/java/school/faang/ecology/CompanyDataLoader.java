package school.faang.ecology;

import lombok.NoArgsConstructor;
import school.faang.ecology.domain.EnvironmentalImpact;
import school.faang.ecology.domain.EnvironmentalImpactType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@NoArgsConstructor
public class CompanyDataLoader {

    public Set<EnvironmentalImpact> loadFromFile(String filePath) throws IOException {
        var path = Paths.get(filePath);
        Set<EnvironmentalImpact> environmentalImpacts = new HashSet<>();
        try (var lines = Files.lines(path)) {
            lines.forEach(line -> {
                if (!line.contains("id")) {
                    var split = line.split(",");
                    var id = Integer.parseInt(split[0]);
                    var companyId = Integer.parseInt(split[1]);
                    var volume = Double.parseDouble(split[2]);
                    var date = LocalDate.parse(split[3], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
                    var type = EnvironmentalImpactType.valueOf(split[4]);
                    var environmentalImpact = new EnvironmentalImpact(id, companyId, volume, date, type);
                    environmentalImpacts.add(environmentalImpact);
                }
            });
        }
        return environmentalImpacts;
    }
}
