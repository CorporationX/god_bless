package school.faang.bjs2_89777;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_AMOUNT = 10;
    private static final int WAITING_TIME = 3;

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(10000);
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person(
                    String.valueOf(random.nextInt(1, 1000)),
                    String.valueOf(random.nextInt(1, 1000)),
                    random.nextInt(1, 1000),
                    String.valueOf(random.nextInt(1, 1000))
                    )
            );
        }
        int groupSize = persons.size() / THREAD_AMOUNT;
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);
        for (int i = 0; i < THREAD_AMOUNT; i++) {
            List<Person> group = persons.subList(i * groupSize, (i + 1) * groupSize - 1);
            executor.execute(new PersonInfoPrinter(group));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(WAITING_TIME, TimeUnit.MINUTES)) {
                log.error("Поток main не дождался окончания работы остальных потоков.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ожидания потока main были прерваны.");
        }
        log.debug("Все потоки завершили свою работу успешно.");
    }
}
