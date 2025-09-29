package school.faang.bjs2_93555;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class CollaborativeDocument {
    private final ConcurrentHashMap<String, String> sections = new ConcurrentHashMap<>();

    public void addData(@NonNull String sectionId, @NonNull String data) {
        sections.put(sectionId, data);
    }

    public String getData(@NonNull String sectionId) {
        return sections.get(sectionId);
    }
}
