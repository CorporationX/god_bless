package faang.school.godbless.sprint5.multithreading_conc.task2_google;

import lombok.Getter;

public class DocumentSection {

    @Getter
    private final String id;

    private final CollaborativeDocument document;

    public DocumentSection(String id, CollaborativeDocument document) {
        this.id = id;
        this.document = document;
    }

    public String get() {
        return document.get(id);
    }

    public void add(String text) {
        document.put(id, text);
    }
}
