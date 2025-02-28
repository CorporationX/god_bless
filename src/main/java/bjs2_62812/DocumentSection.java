package bjs2_62812;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DocumentSection {
    @Getter
    private final String id;
    private final CollaborativeDocument document;

    public String read() throws SectionNotFoundException {
        return document.getData(id);
    }

    public void write(String data) {
        document.addData(id, data);
    }
}
