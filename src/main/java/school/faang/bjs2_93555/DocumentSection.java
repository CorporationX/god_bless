package school.faang.bjs2_93555;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class DocumentSection {
    private String id;
    private CollaborativeDocument document;

    public String read() {
        return document.getData(id);
    }

    public void write(@NonNull String data) {
        document.addData(id, data);
    }
}
