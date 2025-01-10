package school.faang.bjs251188;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record DocumentSectionProcessor(DocumentSection documentSection) implements Runnable {

    private static final long PROCESS_TIME = 3000L;

    @Override
    public void run() {
        String currentData = documentSection.read();
        process(currentData);

        try {
            Thread.sleep(PROCESS_TIME);
        } catch (InterruptedException e) {
            log.error("The thread was interrupted {}", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }

    public void process(String data) {
        String readData = documentSection.read();
        documentSection.write(readData);
    }
}