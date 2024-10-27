package school.faang.google.docs;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CollaborativeDocument {
    private final ConcurrentMap<String, String> sections = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        sections.put(sectionId, data);
    }

    public String getData(String sectionId) {
        if (!sections.containsKey(sectionId)) {
            throw new IllegalArgumentException("Раздел не был найден: " + sectionId);
        }
        return sections.get(sectionId);
    }

    @Override
    public String toString() {
        return sections.toString();
    }
}
