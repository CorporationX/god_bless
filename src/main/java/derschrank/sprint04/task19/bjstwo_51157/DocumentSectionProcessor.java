package derschrank.sprint04.task19.bjstwo_51157;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DocumentSectionProcessor implements Runnable {
    private final Random rnd;
    private Section section;

    public DocumentSectionProcessor(Section section) {
        this.section = section;
        rnd = ThreadLocalRandom.current();
    }

    private void process(String data) {
        String processedData;
        if (rnd.nextInt(10) % 2 == 0) {
            processedData = data.toLowerCase();
        } else {
            processedData = data.toUpperCase();
        }
        section.write(processedData);
    }

    @Override
    public void run() {
        process(section.read());
        System.out.println("Processed data: " + section.read());
    }
}
