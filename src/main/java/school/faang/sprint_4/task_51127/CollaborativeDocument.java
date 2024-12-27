package school.faang.sprint_4.task_51127;

import lombok.NonNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    private final Map<String, String> sections = new ConcurrentHashMap<>();

    public void addData(@NonNull String sectionId,
                         @NonNull String data) {
        sections.put(sectionId, data);
    }

    public String getData(@NonNull String sectionId) {
        return sections.get(sectionId);
    }

    public Map<String, String> getSections() {
        return Map.copyOf(sections);
    }
}
