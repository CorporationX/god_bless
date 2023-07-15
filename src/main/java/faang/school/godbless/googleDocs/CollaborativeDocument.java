package faang.school.godbless.googleDocs;

import lombok.Getter;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class CollaborativeDocument {
    private final ConcurrentHashMap<String, String> documentSections;

    public CollaborativeDocument() {
        this.documentSections = new ConcurrentHashMap<>();
    }

    public void addDataToSection(String sectionId, String data) {
        documentSections.put(sectionId, data);
    }

    public String getDataFromSection(String sectionId) {
        return documentSections.get(sectionId);
    }

}
