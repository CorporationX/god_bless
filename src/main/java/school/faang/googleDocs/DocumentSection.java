package school.faang.googleDocs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DocumentSection {
    private final String id;
    private final CollaborativeDocument document;

    public String read() {
        return document.getData(id);
    }

    public void write(String data) {
        document.addData(id, data);
    }
}
