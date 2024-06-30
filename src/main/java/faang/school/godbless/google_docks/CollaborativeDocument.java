package faang.school.godbless.google_docks;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Getter
public class CollaborativeDocument {
    private final Map<String, String> idAndSectionMap = new ConcurrentHashMap<>();

    public void addData(String id, String data) {
        idAndSectionMap.put(id, data);
        log.info("Data with id: " + id + " was added to Collaborative document");
    }

    public Optional<String> getData(String id) {
        return Optional.ofNullable(idAndSectionMap.get(id));
    }
}
