package school.faang.bjs2_80812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CompanyDataLoader {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public List<EnvironmentalImpact> loadImpacts(String resourceName) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourceName);
        if (inputStream == null) {
            throw new IOException("Resource not found: " + resourceName);
        }

        List<EnvironmentalImpact> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length < 5) {
                    continue;
                }
                int id = Integer.parseInt(tokens[0].trim());
                int companyId = Integer.parseInt(tokens[1].trim());
                double volume = Double.parseDouble(tokens[2].trim());
                LocalDate date = LocalDate.parse(tokens[3].trim(), FORMATTER);
                ImpactType type = ImpactType.valueOf(tokens[4].trim());

                EnvironmentalImpact impact = new EnvironmentalImpact(id, companyId, volume, date, type);
                result.add(impact);
            }
        }

        return result;
    }
}
