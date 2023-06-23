package faang.school.godbless.EcologicalMonitoring;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompanyDataLoader {
    public List<EnvironmentalImpact> dataLoad(){
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
        records.stream().filter()
        return null;
    }
}
