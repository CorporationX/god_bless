package faang.school.godbless.Sprint4Future.GoogleDocs;

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;

@Data
public class CollaborativeDocument {

    private ConcurrentHashMap<String, String> document = new ConcurrentHashMap<>();

    public void addData(String identifier, String data) {
        document.put(identifier, data);
    }

    public String getData(String identifier) {
        return document.get(identifier);
    }
}
