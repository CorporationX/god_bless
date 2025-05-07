package school.faang.googledocs;

import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;

@Getter
public class CollaborativeDocument {
    private final ConcurrentHashMap<String, String> document = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        document.put(sectionId, data);
    }

    public String getData(String sectionId) {
        return document.getOrDefault(sectionId, "NoValue");
    }
}
