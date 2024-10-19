package school.faang.help.colleague;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_OF_EMPLOYEES = 10000;

    public static void main(String[] args) {
        List<Person> persons = IntStream.rangeClosed(1, NUM_OF_EMPLOYEES)
                .parallel()
                .mapToObj(i -> new Person(
                        "Name" + i,
                        "Surname" + i,
                        20 + (i % 20),
                        "Workplace" + (i % 10)))
                .toList();

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(availableProcessors);

        int batchSize = persons.size() / availableProcessors;
        for (int i = 0; i < availableProcessors; i++) {
            int startIndx = i * batchSize;
            int endIndx = Math.min(startIndx + batchSize, persons.size());
            executor.submit(new PersonInfoPrinter(persons.subList(startIndx, endIndx)));
        }
        executor.shutdown();

        try {
            if (executor.awaitTermination(20, TimeUnit.MINUTES)) {
                System.out.println("Работа успешно завершена!");
            }
        } catch (InterruptedException e) {
            log.error("Не удалось напечатать информацию про всех сотрудников " + e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }
}
