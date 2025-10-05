package school.faang.m1.concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    ConcurrentHashMap<String, String> sections = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        sections.merge(sectionId, data, (oldVal, newVal) -> oldVal + newVal);
    }

    public String getData(String sectionId) {
        return sections.getOrDefault(sectionId, "");
    }

    public Map<String, String> snapshot() {
        return Map.copyOf(sections);
    }
}
