package school.faang.multithreading.concurr.google.docs;

import lombok.ToString;

@ToString
public class DocumentSection {
    private final String sectionId;
    private final CollaborativeDocument document;

    public DocumentSection(String sectionId, CollaborativeDocument document) {
        this.sectionId = sectionId;
        this.document = document;
    }

    public String read() {
        return document.getData(sectionId);
    }

    public void write(String data) {
        document.addData(sectionId, data);
    }
}
