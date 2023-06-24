package faang.school.godbless.EcologicalMonitoring;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompanyDataLoader {
    public List<EnvironmentalImpact> dataLoad() {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./src/main/java/faang/school/godbless/EcologicalMonitoring/csvFile.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records.stream()
                .map(list -> new EnvironmentalImpact(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4)))
                .toList();

    }
}
