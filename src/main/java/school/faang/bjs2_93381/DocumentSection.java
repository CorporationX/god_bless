package school.faang.bjs2_93381;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class DocumentSection {
    @Getter
    private String id;
    private CollaborativeDocument document;

    public String read() {
        return document.getData(id);
    }

    public void write(String data) {
        document.addData(id, data);
    }
}
