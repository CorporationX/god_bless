package school.faang.task415.document;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSection {
    private int id;
    private CollaborativeDocument document;

    public String read() {
        return document.getData(String.valueOf(id));
    }

    public void write(String data) {
        document.addData(String.valueOf(id), data);
    }
}
