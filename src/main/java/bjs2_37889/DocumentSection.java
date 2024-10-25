package bjs2_37889;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
