package school.faang.job.analyzer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class JobScraper {
    private static final Set<Character> PARSING_KEYS = Set.of(':', '[', ']');

    public static Job parseToJob(String json) {
        Map<String, String> filedToValue = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        String key;
        String value;
        for (int i = 1; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '"' && stack.isEmpty() || PARSING_KEYS.contains(c)) {
                stack.push(i);
            } else if (c == ',' || c == '}' || i == json.length() - 1) {
                if (json.charAt(stack.peek()) == '[') {
                    continue;
                }
                if (json.charAt(stack.peek()) == ']') {
                    stack.pop();
                    stack.pop();
                }
                int valueStartIndx = stack.pop();
                int filedStartIndx = stack.pop();
                value = json.substring(valueStartIndx + 1, i)
                        .replaceAll("\"", "")
                        .trim();
                key = json.substring(filedStartIndx, valueStartIndx - 1)
                        .replaceAll("\"", "")
                        .trim();
                filedToValue.put(key, value);
                stack.push(i + 1);
            }
        }

        String position = filedToValue.get("position");
        List<String> requirements = Arrays.stream(filedToValue.get("position")
                        .replaceAll("[\\[\\]]", "")
                        .split("\\PL+"))
                .toList();
        int salary = Integer.parseInt(filedToValue.get("salary"));
        String location = filedToValue.get("location");
        LocalDate datePosted = LocalDate.parse(filedToValue.get("datePosted"));
        return new Job(position, requirements, salary, location, datePosted);
    }
}
