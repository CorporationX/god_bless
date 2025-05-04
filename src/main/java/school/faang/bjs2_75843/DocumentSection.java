package school.faang.bjs2_75843;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DocumentSection {
    @Getter
    private final String id;
    private final CollaborativeDocument document;

    public String read() {
        return document.getData(id);
    }

    public void write(String data) {
        document.addData(id, data);
    }
}
