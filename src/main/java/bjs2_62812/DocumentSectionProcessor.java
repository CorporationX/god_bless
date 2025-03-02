package bjs2_62812;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private final DocumentSection section;

    @Override
    public void run() {
        var sectionData = section.read();
        if (sectionData.isPresent()) {
            process(sectionData.get());
            log.info("Секция {} обработана", section.getId());
        } else {
            log.info("Секция {} не найдена в документе", section.getId());
        }
    }

    private void process(String data) {
        var processedData = data.toUpperCase();
        section.write(processedData);
    }
}
