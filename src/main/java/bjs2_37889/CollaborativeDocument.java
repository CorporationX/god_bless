package bjs2_37889;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class CollaborativeDocument {
    private final Map<String, String> document = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        document.put(sectionId, data);
    }

    public String getData(String sectionId) {
        return document.getOrDefault(sectionId, "");
    }
}
