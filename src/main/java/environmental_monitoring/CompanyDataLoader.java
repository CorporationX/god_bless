package environmental_monitoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CompanyDataLoader {
    public List<EnvironmentalImpact> loadEnvironmentalImpacts(String fileName) {
        List<EnvironmentalImpact> impacts = new ArrayList<>();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            // Пропускаем заголовок
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                int id = Integer.parseInt(fields[0]);
                int companyId = Integer.parseInt(fields[1]);
                double volume = Double.parseDouble(fields[2]);
                String  date = fields[3];
                ImpactType type = ImpactType.valueOf(fields[4]);

                EnvironmentalImpact impact = new EnvironmentalImpact(id, companyId, volume, date, type);
                impacts.add(impact);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return impacts;
    }
}
