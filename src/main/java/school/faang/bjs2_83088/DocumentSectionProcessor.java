package school.faang.bjs2_83088;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DocumentSectionProcessor implements Runnable {

    private final DocumentSection section;

    public void process(String data) {
        String processedData = data.toUpperCase();
        section.write(processedData);
    }

    @Override
    public void run() {
        String currentData = section.read();
        process(currentData);
        log.info("Processed data for the section {}", section.read());
    }
}
