package school.faang.googledocs;

import lombok.AllArgsConstructor;

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
