package school.faang.m1.concurrency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class DocumentSectionProcessor implements Runnable {

    private final DocumentSection section;
    private final List<String> inputs;
    private final int artificialDelayMs;

    @Override
    public void run() {
        try {
            for (String raw : inputs) {
                String processed = process(raw);
                section.write(processed);
                if (artificialDelayMs > 0) {
                    Thread.sleep(artificialDelayMs);
                }
                String current = section.read();
                System.out.printf("[%s] %s => now: %s%n", Thread.currentThread().getName(), section.id(), current);
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    /*
    to upper case
     */
    public String process(String data) {
        return data.toUpperCase();
    }
}
