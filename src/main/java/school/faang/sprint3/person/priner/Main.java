package school.faang.sprint3.person.priner;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static final Integer PEOPLE_SIZE = 10000;
    public static final Integer THREAD_COUNT = 8;


    public static void main(String[] args) {

        List<Person> people = IntStream.range(0, PEOPLE_SIZE)
                .mapToObj(index -> new Person())
                .toList();

        int actualThreadCount = Math.min(THREAD_COUNT, PEOPLE_SIZE);
        int batchSize = Math.max(1, (int) Math.ceil((double) PEOPLE_SIZE / actualThreadCount));
        ExecutorService executorService = Executors.newFixedThreadPool(actualThreadCount);
        IntStream.range(0, actualThreadCount)
                .forEach(currentBatchNumber -> {
                    int start = currentBatchNumber * batchSize;
                    int end = Math.min(start + batchSize, PEOPLE_SIZE);
                    executorService.execute(new PersonInfoPrinter(people.subList(start, end)));
                });
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Успешное выполнение");
            }
        } catch (InterruptedException interruptedException) {
            System.out.println("Прерывание во время ожидания");
        }
    }
}
