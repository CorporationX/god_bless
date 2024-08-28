package faang.school.godbless.googleDocs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class DocumentSection {
    @Getter
    private String id;
    private CollaborativeDocument document;

    public void addDataToSection(String data) {
        document.addData(id, data);
    }

    public String getDataFromSection() {
        return document.getData(id);
    }
}
