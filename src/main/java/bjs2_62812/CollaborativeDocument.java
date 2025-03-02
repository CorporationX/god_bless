package bjs2_62812;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    // key -  это идентификатор раздела документа, value - данные раздела
    private final ConcurrentHashMap<String, String> sections = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        sections.put(sectionId, data);
    }

    public Optional<String> getData(String sectionId) {
        var data = sections.get(sectionId);

        return data == null ? Optional.empty() : Optional.of(data);
    }
}
