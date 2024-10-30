package school.faang.google_docs_BJS2_39364;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    private Map<String, String> document = new ConcurrentHashMap<>();

    public void addData(String key, String value) {
        document.put(key, value);
    }

    public String getData(String key) {
        return document.get(key);
    }
}