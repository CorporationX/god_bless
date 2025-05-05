package school.faang.concurrency.google_docs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DocumentSectionProcessor implements Runnable {

    private final DocumentSection section;

    private void process(String data) {
        section.write(data.toUpperCase());
    }

    @Override
    public void run() {
        String dataToProcess = section.read();
        process(dataToProcess);
        log.info("New section data: '{}'", section.read());
    }
}
