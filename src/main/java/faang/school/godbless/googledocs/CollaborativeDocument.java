package faang.school.godbless.googledocs;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    private final Map<String, String> sections;

    public CollaborativeDocument() {
        this.sections = new ConcurrentHashMap<>();
    }

    public void addSectionData(String sectionId, String data) {
        this.sections.put(sectionId, data);
    }

    public String getSectionData(String sectionId) {
        return this.sections.get(sectionId);
    }

    public Map<String, String> getAllSections() {
        return sections;
    }
}