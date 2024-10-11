package environmental_monitoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CompanyDataLoader {
    /**
     * Loads environmental impacts from the given CSV file.
     *
     * The format of the CSV file is as follows:
     * <ul>
     *     <li>id - int</li>
     *     <li>companyId - int</li>
     *     <li>volume - double</li>
     *     <li>date - String</li>
     *     <li>type - ImpactType</li>
     * </ul>
     *
     * @param fileName the name of the CSV file to read from
     * @return a list of environmental impacts
     */
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
