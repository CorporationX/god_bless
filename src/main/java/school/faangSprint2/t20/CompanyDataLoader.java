package school.faangSprint2.t20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CompanyDataLoader {
    public List<EnvironmentalImpact> loadData(String filePath) {
        List<EnvironmentalImpact> impacts = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                EnvironmentalImpact impact = new EnvironmentalImpact(
                        values[0],
                        values[1],
                        Double.parseDouble(values[2]),
                        LocalDate.parse(values[3], formatter)
                );
                impacts.add(impact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return impacts;
    }
}