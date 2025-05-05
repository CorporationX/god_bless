package school.faang.concurrency.google_docs;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@ToString
public class CollaborativeDocument {

    private final Map<String, String> collabDoc = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        collabDoc.put(sectionId, data);
        log.info("Data '{}' was written to section {}", data, sectionId);
    }

    public String getData(String sectionId) {
        return collabDoc.getOrDefault(sectionId, "");
    }
}
