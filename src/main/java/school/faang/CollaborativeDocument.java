package school.faang;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    private final Map<String, String> sections = new ConcurrentHashMap<>();

    public void addData(String section, String data) {
        sections.put(section, data);
    }

    public String getData(String section) {
        return sections.get(section);
    }

}
