package faang.school.godbless.googledocs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class DocumentSectionProcessor implements Runnable {
    private final DocumentSection section;
    private final String newData;

    @Override
    public void run() {
        String processedData = newData.toUpperCase();
        section.writeContent(processedData);
        log.info("Processed section {}", section.readContent());
    }
}