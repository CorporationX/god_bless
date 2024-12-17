package school.faang.sprint_2.task_46716;

import lombok.NonNull;
import school.faang.sprint_2.task_46716.entity.EnvironmentalImpact;
import school.faang.sprint_2.task_46716.entity.ImpactType;
import school.faang.sprint_2.task_46716.repository.CompanyRepository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

public class CompanyDataLoader {

    public List<EnvironmentalImpact> loadEnvironmentalImpactData(@NonNull String fileName) {
        InputStream resourceAsStream = CompanyDataLoader.class.getResourceAsStream(fileName);
        if (resourceAsStream == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }

        Stream<String> lines = new BufferedReader(new InputStreamReader(resourceAsStream)).lines();

        return lines.map(line -> {
            String[] impactLine = line.split(",");
            int impactId = Integer.parseInt(impactLine[0]);
            int companyId = Integer.parseInt(impactLine[1]);
            double volume = Double.parseDouble(impactLine[2]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
            LocalDate date = LocalDate.parse(impactLine[3], formatter);
            ImpactType impactType = ImpactType.valueOf(impactLine[4]);

            if (CompanyRepository.getCompanyById(companyId).isEmpty()) {
                // Так как файла с компаниями нет, генерирую случайную компанию
                CompanyRepository.generateCompany(companyId);
            }

            return new EnvironmentalImpact(impactId, companyId, volume, date, impactType);
        }).toList();
    }
}
