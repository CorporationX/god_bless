package school.faang.multithreading.concurr.google.docs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DocumentSectionProcessor implements Runnable {
    private static final int TIME_TO_SLEEP = 2000;
    private final DocumentSection documentSection;

    public DocumentSectionProcessor(DocumentSection documentSection) {
        this.documentSection = documentSection;
    }

    @Override
    public void run() {
        try {
            String read = documentSection.read();
            Thread.sleep(TIME_TO_SLEEP);
            String processResult = process(read);
            log.info("Обработка секции: {} результат: {}", documentSection, processResult);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String process(String data) {
        return data.toUpperCase();
    }
}
