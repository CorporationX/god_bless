package school.faang.task_51137;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    private final Map<String, String> sections = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        sections.compute(sectionId, (key, value) -> value == null ? data : value + data);
    }

    public String getData(String sectionId) {
        return sections.getOrDefault(sectionId, "default");
    }

    public void printAllData() {
        sections.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
