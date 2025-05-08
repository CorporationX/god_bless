package school.faang.googledocs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class DocumentSection {
    private final String id;
    private final CollaborativeDocument document;

    public String read() {
        log.info("Считали данные с документа {}, раздела {}", document, id);
        return document.getData(id);
    }

    public void write(String data) {
        log.info("Записали данные в документ {}, раздел {}", document, id);
        document.addData(id, data);
    }
}
