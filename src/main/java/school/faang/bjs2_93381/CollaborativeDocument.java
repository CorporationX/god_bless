package school.faang.bjs2_93381;

import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    @Getter
    private ConcurrentHashMap<String, String> sections = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        sections.put(sectionId, data);
    }

    public String getData(String sectionId) {
        return sections.get(sectionId);
    }
}
