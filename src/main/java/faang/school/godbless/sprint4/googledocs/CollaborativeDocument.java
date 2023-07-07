package faang.school.godbless.sprint4.googledocs;


import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    ConcurrentHashMap<String, String> documents;

    public CollaborativeDocument() {
        documents = new ConcurrentHashMap<String, String>();
    }



    public void addDataToSection(String sectionId, String data) {
        documents.put(sectionId, data);
    }

    public String getDataFromSection(String sectionId) {
        return documents.get(sectionId);
    }
}
