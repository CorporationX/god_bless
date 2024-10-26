package school.faang.google_docs_BJS2_39364;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DocumentSection {
    private String id;
    private CollaborativeDocument document;

    public String read() {
        return document.getData(id);
    }

    public void write(String data) {
        document.addData(id, data);
    }
}