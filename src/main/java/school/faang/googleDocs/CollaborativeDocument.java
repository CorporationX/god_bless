package school.faang.googleDocs;

import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;

@Getter
public class CollaborativeDocument {
    private final ConcurrentHashMap<String, String> sections = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        sections.put(sectionId, data);
    }

    public String getData(String sectionId) {
        return sections.get(sectionId);
    }

    public void printData() {
        sections.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
