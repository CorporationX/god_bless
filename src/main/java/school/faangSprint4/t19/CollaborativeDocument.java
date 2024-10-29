package school.faangSprint4.t19;

import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    private final ConcurrentHashMap<String, String> sections = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        sections.put(sectionId, data);
    }

    public String getData(String sectionId) {
        return sections.get(sectionId);
    }

    public void printAllSections() {
        System.out.println("\nFinal document contents:");
        sections.forEach((id, content) ->
                System.out.println("Section " + id + ": " + content));
    }
}