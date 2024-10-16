package school.faang.multithreading.parallelism.help.colleague;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private final static int THREAD_POOL_SIZE = 5;
    private final static int PERSONS_SIZE = 10_000;

    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = IntStream.rangeClosed(1, PERSONS_SIZE)
                .mapToObj(i -> new Person("Name" + i, "Surname" + i, i, "Workplace" + i))
                .toList();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        int batchSize = PERSONS_SIZE / THREAD_POOL_SIZE;

        log.info("Начинаем параллельное выполнение задач");
        IntStream.range(0, THREAD_POOL_SIZE).forEach(i -> {
            int start = i * batchSize;
            int end = (i == THREAD_POOL_SIZE - 1) ? persons.size() : (i + 1) * batchSize - 1;
            List<Person> batch = persons.subList(start, end);
            executor.submit(new PersonInfoPrinter(batch));
        });

        executor.shutdown();
        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            log.info("Все задачи завершены");
        }
    }
}
