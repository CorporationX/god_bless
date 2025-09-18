package school.faang.bjs2_89777;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    @SuppressWarnings({"checkstyle:LocalVariableName", "checkstyle:AbbreviationAsWordInName"})
    public static void main(String[] args) {
        int THREAD_AMOUNT = 10;
        int WAITING_TIME = 3;
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
                System.out.println("Поток main не дождался окончания работы остальных потоков.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ождиания потока main были прерваны.");
        }
        System.out.println("Все потоки завершили свою работу успешно.");
    }
}
