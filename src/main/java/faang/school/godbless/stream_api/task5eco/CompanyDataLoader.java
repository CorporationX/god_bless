package faang.school.godbless.stream_api.task5eco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CompanyDataLoader {
    public static List<EnvironmentalImpact> loadEnvironmentalImpacts(String filePath) {
        List<EnvironmentalImpact> impacts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Пропустить заголовок

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Добавим проверку на пустую строку перед разбором данных
                if (data.length != 5 || Arrays.stream(data).anyMatch(String::isEmpty)) {
                    continue;
                }

                int id = Integer.parseInt(data[0]);
                int companyId = Integer.parseInt(data[1]);
                double volume = Double.parseDouble(data[2]);
                Date date = new SimpleDateFormat("yyyy.MM.dd").parse(data[3]);
                ImpactType type = ImpactType.valueOf(data[4]);

                EnvironmentalImpact impact = new EnvironmentalImpact(id, companyId, volume, date, type);
                impacts.add(impact);
                System.out.println("Loaded impact: " + impact);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return impacts;
    }
}

