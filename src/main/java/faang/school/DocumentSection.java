package faang.school;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSection {
    private final String id;
    private final CollaborativeDocument doc;

    public void writeContent(String content) {
        doc.addData(id, content);
    }

    public String readContent() {
        return doc.getData(id);
    }
}
