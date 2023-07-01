package faang.school.godbless.help;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final int PERSONS_COUNT = 10_000;
    private static final int THREADS_COUNT = 10;
    private static final List<Person> PERSON_LIST = getPersonList();
    private static final int BATCH_SIZE = PERSON_LIST.size() / THREADS_COUNT;
    private static final int TIMEOUT = 30_000;


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

        int startIndex = 0;
        int endIndex = BATCH_SIZE;

        for (int i = 0; i < THREADS_COUNT; i++) {
            List<Person> personsBatch = PERSON_LIST.subList(startIndex, endIndex);
            executorService.submit(new PersonNamePrinter(personsBatch));

            startIndex = endIndex;
            endIndex += BATCH_SIZE;
        }
        executorService.shutdown();

        System.out.println(">>>>>>>>>>>> isTerminated = " + executorService.awaitTermination(TIMEOUT, TimeUnit.MILLISECONDS));
    }

    private static List<Person> getPersonList() {
        return IntStream.range(0, Main.PERSONS_COUNT)
            .mapToObj(i -> new Person(String.valueOf(i)))
            .collect(Collectors.toList());
    }
}
