package faang.school.godbless.kxnvg.googledocs;

import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {

    @Getter
    private static ConcurrentHashMap<String, String> document;

    public CollaborativeDocument() {
        document = new ConcurrentHashMap<>();
    }

    public void addDocumentSection(String id, String value) {
        document.put(id, value);
    }

    public String getDocumentSection(String id) {
        return document.get(id);
    }
}
