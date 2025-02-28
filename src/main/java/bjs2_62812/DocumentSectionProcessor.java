package bjs2_62812;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private final DocumentSection section;

    @Override
    public void run() {
        try {
            var data = section.read();
            process(data);
        } catch (SectionNotFoundException e) {
            log.error("Не удалось прочитать данные секции: {}", e.getMessage(), e);
        }
    }

    private void process(String data) {
        var processedData = data.toUpperCase();
        section.write(processedData);
    }
}
