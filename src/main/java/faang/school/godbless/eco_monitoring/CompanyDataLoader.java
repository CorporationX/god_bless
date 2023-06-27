package faang.school.godbless.eco_monitoring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompanyDataLoader {
    public static List<EnvironmentalImpact> loadData(String filePath){
        List<EnvironmentalImpact> environmentalImpacts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    int id = Integer.parseInt(data[0]);
                    int companyId = Integer.parseInt(data[1]);
                    Double volume = Double.parseDouble(data[2]);
                    LocalDate date = LocalDate.parse(data[3]);
                    ImpactType type = ImpactType.valueOf(data[4]);

                    EnvironmentalImpact environmentalImpact = new EnvironmentalImpact(id, companyId, volume, date, type);
                    environmentalImpacts.add(environmentalImpact);
                }
            }
        } catch (IOException e) {
            System.out.println("Error while processing: " + e.getMessage());
        }

        return environmentalImpacts;
    }
}
