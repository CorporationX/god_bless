package school.faang.colleague;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
public class Main {

    private static final int CHUNK_SIZE = 1000;
    private static final int THREAD_COUNT =  Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws IOException {
        var file = new File("src/main/resources/employee_10000.json");

        var executor = Executors.newFixedThreadPool(THREAD_COUNT);
        List<Person> buffer = new ArrayList<>(CHUNK_SIZE);

        try (var personStream = PersonStreamLoader.load(file)) {
            personStream.forEach(person -> {
                buffer.add(person);
                if (buffer.size() >= CHUNK_SIZE) {
                    executor.execute(new PersonInfoPrinter(List.copyOf(buffer)));
                    buffer.clear();
                }
            });
        }

        if (!buffer.isEmpty()) {
            executor.execute(new PersonInfoPrinter(buffer));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
}
