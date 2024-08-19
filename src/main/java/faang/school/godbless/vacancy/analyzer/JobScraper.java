package faang.school.godbless.vacancy.analyzer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class JobScraper {
    public static Job parse(String json) {
        Map<String, String> jsonMap = Arrays.stream(json.trim().substring(1, json.lastIndexOf("}")).split(",\n"))
                .map(pair -> pair.split(":"))
                .collect(Collectors.toMap(
                        pair -> pair[0].trim().substring(1, pair[0].trim().lastIndexOf("\"")),
                        pair -> pair[1].trim().startsWith("\"") ?
                                pair[1].trim().substring(1, pair[1].trim().lastIndexOf("\"")) :
                                pair[1].trim().substring(0, pair[1].trim().length() - 1)));

        Job job = new Job();
        job.setPosition(jsonMap.get("position"));
        job.setLocation(jsonMap.get("location"));
        job.setSalary(Integer.valueOf(jsonMap.get("salary")));
        job.setRequirements(Arrays.stream(jsonMap.get("requirements").substring(1).split(","))
                .map(requirement -> requirement.trim().replace("\"", ""))
                .toList());
        job.setCreationDate(LocalDate.parse(jsonMap.get("creationDate")));

        return job;
    }
}
