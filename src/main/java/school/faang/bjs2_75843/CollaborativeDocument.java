package school.faang.bjs2_75843;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    private final Map<String, String> document = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        document.putIfAbsent(sectionId, data);
    }

    public String getData(String sectionId) {
        String data = document.get(sectionId);
        if (data == null) {
            throw new DocumentNotFoundException(sectionId);
        }
        return data;
    }
}
