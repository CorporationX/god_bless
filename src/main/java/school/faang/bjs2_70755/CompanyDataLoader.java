package school.faang.bjs2_70755;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@NoArgsConstructor
@Slf4j
public class CompanyDataLoader {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public List<EnvironmentalImpact> readDataFromScv(String fileName) {
        List<EnvironmentalImpact> impacts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(fileName))))) {

            String line;

            reader.readLine();
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length != 5) {
                    continue;
                }

                try {
                    long id = Long.parseLong(parts[0].trim());
                    long companyId = Long.parseLong(parts[1].trim());
                    double volume = Double.parseDouble(parts[2].trim());
                    LocalDate date = LocalDate.parse(parts[3].trim(), DATE_FORMATTER);
                    EnvironmentalImpactType type = EnvironmentalImpactType.valueOf(parts[4].trim());

                    impacts.add(new EnvironmentalImpact(id, companyId, volume, date, type));
                } catch (Exception e) {
                    log.error("Ошибка при обработке строки: {}", line);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Не удалось загрузить файл: " + fileName, e);
        }
        return impacts;
    }
}
