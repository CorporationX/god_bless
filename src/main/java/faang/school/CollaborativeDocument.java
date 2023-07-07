package faang.school;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    Map<String, String> title = new ConcurrentHashMap<>();

    public void addData(String key, String data) {
        title.put(key,data);
    }
    public String getData(String key) {
        return title.get(key);
    }
}
