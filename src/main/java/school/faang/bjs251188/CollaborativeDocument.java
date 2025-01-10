package school.faang.bjs251188;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Getter
@RequiredArgsConstructor
public class CollaborativeDocument {
    private final Map<Integer, String> documents = new ConcurrentHashMap<>();

    public void addData(int sectionId, String data) {
        documents.put(sectionId, data);
        log.info("Data of {} have added", data);
    }

    public String getData(int sectionId) {
        log.info("Data with id {} have receive", sectionId);
        return documents.getOrDefault(sectionId, "Default");
    }

    public void printAllData() {
        documents.forEach((key, value) -> log.info("{}: {}", key, value));
    }
}