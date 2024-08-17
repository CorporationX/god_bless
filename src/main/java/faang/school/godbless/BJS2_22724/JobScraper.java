package faang.school.godbless.BJS2_22724;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JobScraper {
    public Job parseJsonToJob(String jsonString) {
        Map<String, String> resultMap = new HashMap<>();
        ArrayList<String> nextArray = new ArrayList<>((Arrays.asList(jsonString.split("\\\\n"))));
        nextArray = nextArray.stream()
                .filter(string -> !string.contains("}"))
                .filter(string -> !string.contains("{"))
                .map(string -> string.replace("\\\"", ""))
                .map(string -> string.substring(0, string.length() - 1))
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<String> requirements = nextArray.stream()
                .filter(string -> !string.contains(":"))
                .map(String::trim)
                .collect(Collectors.toCollection(ArrayList::new));

        nextArray.stream()
                .map(string -> string.split(":"))
                .limit(4)
                .forEach(array -> resultMap.put(array[0].trim(), array[1].trim()));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        requirements.removeIf(String::isEmpty);
        return new Job(resultMap.get("position"), Integer.parseInt(resultMap.get("salary")),
                resultMap.get("location"), LocalDateTime.parse(resultMap.get("date"), dtf), requirements);
    }
}
