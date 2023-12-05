package faang.school.godbless.GoogleDocs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DocumentSection {
    private String id;
    private CollaborativeDocument collaborativeDocument;

    public void writeContent(String content) {
        collaborativeDocument.addData(id, content);
    }

    public String readContent() {
        return collaborativeDocument.getData(id);
    }
}
