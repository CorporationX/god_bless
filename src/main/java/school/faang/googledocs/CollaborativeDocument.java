package school.faang.googledocs;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollaborativeDocument {
    private final ConcurrentHashMap<String, String> sections = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        sections.put(sectionId, data);
    }

    public String getData(String sectionId) {
        return sections.getOrDefault(sectionId, "No data available");
    }
}
