package school.faang.environmentalmonitoring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CompanyDataLoader {

    public List<EnvironmentalImpact> loadEnvironmentalImpactData(String filename) {
        List<EnvironmentalImpact> impacts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                int companyId = Integer.parseInt(values[1]);
                double volume = Double.parseDouble(values[2]);
                String date = values[3];
                String type = values[4];
                impacts.add(new EnvironmentalImpact(id, companyId, volume, date, type));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return impacts;
    }
}

