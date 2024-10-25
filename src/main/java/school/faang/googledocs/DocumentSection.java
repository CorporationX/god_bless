package school.faang.googledocs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentSection {

    private final String id;
    private final CollaborativeDocument document;

    public DocumentSection(String id, CollaborativeDocument document) {
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

