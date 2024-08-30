package faang.school.godbless.BJS2_25370;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        CollaborativeDocument collaborativeDoc = new CollaborativeDocument();
        IntStream.rangeClosed(1, 10).forEach(i -> {
            DocumentSection section = new DocumentSection(i);
            section.write("Hello world! " + i);
            collaborativeDoc.putDocSection(section);
        });

        ThreadLocalRandom random = ThreadLocalRandom.current();
        Thread[] threads = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> {
                    DocumentSection section = collaborativeDoc.get(random.nextInt(1, 10));
                    DocumentSectionProcessor processor = new DocumentSectionProcessor(section);
                    Thread thread = new Thread(processor);
                    thread.start();
                    return thread;
                })
                .toArray(Thread[]::new);

        Arrays.stream(threads).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        collaborativeDoc.getSections()
                .values()
                .forEach(System.out::println);
    }
}