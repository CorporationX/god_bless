package faang.school.godbless.sprint5.multithreading_conc.task2_google;

import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;

@Getter
public class CollaborativeDocument {

    private final ConcurrentHashMap<String, String> document;

    public CollaborativeDocument() {
        this.document = new ConcurrentHashMap<>();
    }

    public void put(String key, String value) {
        this.document.put(key, value);
    }

    public String get(String key) {
        return this.document.get(key);
    }
}
