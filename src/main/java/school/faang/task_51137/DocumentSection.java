package school.faang.task_51137;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
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
