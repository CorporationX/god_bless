package faang.school.godbless.google_docks;

import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class CollaborativeDocument {
    private final Map<String, String> idAndSectionMap = new ConcurrentHashMap<>();

    public void addData(String id, String data) {
        idAndSectionMap.put(id, data);
    }

    public Optional<String> getData(String id) {
        return Optional.ofNullable(idAndSectionMap.get(id));
    }
}
