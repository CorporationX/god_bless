package school.faang.bjs2_75843;

import lombok.Getter;


public class DocumentSection {
    @Getter
    private final String id;
    private final CollaborativeDocument document;

    public DocumentSection(String id, CollaborativeDocument document) {
        if (document == null) {
            throw new IllegalArgumentException("Document is null");
        }
        this.id = id;
        this.document = document;
    }

    public String read() {
        return document.getData(id);
    }

    public void write(String data) {
        document.addData(id, data);
    }
}
