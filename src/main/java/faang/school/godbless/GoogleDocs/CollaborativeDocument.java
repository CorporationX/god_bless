package faang.school.godbless.GoogleDocs;

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;

@Data
public class CollaborativeDocument {
    ConcurrentHashMap<String, String> document;

    public CollaborativeDocument() {
        this.document = new ConcurrentHashMap<>();
    }

    public synchronized void addData(String key, String value) {
        document.put(key, value);
        notify();
    }

    public synchronized String getData(String key) {
        if (!document.containsKey(key)) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return document.get(key);
    }
}
