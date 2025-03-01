package school.faang;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DocumentSection {
    private final String id;
    private final CollaborativeDocument document;

    public String read() {
        log.info("Reading {} from {}", document.getData(id), id);
        return document.getData(id);
    }

    public void write(String data) {
        log.info("Writing {} in {}", data, id);
        document.addData(id, data);
    }
}
