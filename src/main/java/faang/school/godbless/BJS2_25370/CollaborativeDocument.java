package faang.school.godbless.BJS2_25370;

import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;

@Getter
public class CollaborativeDocument {
    private ConcurrentHashMap<Integer, DocumentSection> sections = new ConcurrentHashMap<>();

    public void putDocSection(DocumentSection section) {
        sections.put(section.getId(), section);
    }

    public DocumentSection get(int id) {
        return sections.get(id);
    }
}
