package school.faang.task48090;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final int AGE_FILTER = 60;
    private static final int COUNT_PEOPLE = 10_000;
    private static final int THREAD_POOL = 5;

    public static void main(String[] args) {
        Random random = new Random();
        List<Person> people = new ArrayList<>();

        IntStream.range(0, COUNT_PEOPLE).forEach(i ->
                people.add(new Person("name", "surName",
                        random.nextInt(AGE_FILTER), "workPlace")));


        int batch = people.size() / THREAD_POOL;
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);

        IntStream.range(0, THREAD_POOL).forEach(i -> {
            List<Person> subList = people.subList(i * batch, (i + 1) * batch);
            executorService.execute(new PersonInfoPrinter(subList));
        });

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Все задачи завершены.");
            }
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
