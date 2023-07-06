package faang.school.godbless.Sprint4Future.GoogleDocs;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSection {
    private String id;
    private CollaborativeDocument document;

    public void addData(String data) {
        document.addData(id, data);
    }

    public String getData() {
        return document.getData(id);
    }

}
