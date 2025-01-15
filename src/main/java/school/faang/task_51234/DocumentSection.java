package school.faang.task_51234;

import lombok.AllArgsConstructor;

@AllArgsConstructor
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
