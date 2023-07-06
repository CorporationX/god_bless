package faang.school.godbless.googleDocs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentSection {
    private String id;
    private CollaborativeDocument document;

    public DocumentSection(String id, CollaborativeDocument document) {
        this.id = id;
        this.document = document;
    }

    public void writeContent(String content) {
        document.addDataToSection(id, content);
    }

    public String readContent() {
        return document.getDataFromSection(id);
    }

}
