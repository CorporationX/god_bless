package faang.school.godbless.googleDocs;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    private final Map<String, String> doc = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        doc.put(sectionId, data);
    }

    public String getData(String sectionId) {
        if (doc.containsKey(sectionId)) {
            return doc.get(sectionId);
        }
        System.out.println("No data found for section with id " + sectionId);
        return null;
    }
}
