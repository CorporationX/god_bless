package school.faang.helpacolleague;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class App {
    private static final int THREADS_AMOUNT = 10;
    private static final int PEOPLE_AMOUNT = 10000;

    public static void main(String[] args) throws InterruptedException {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < PEOPLE_AMOUNT; i++) {
            String name = "Name" + i;
            String surname = "Surname" + i;
            int age = 20 + (i % 30);
            String workplace = "Company" + (i % 100); // 100
            people.add(new Person(name, surname, age, workplace));
        }

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_AMOUNT);

        int chunkSize = PEOPLE_AMOUNT / THREADS_AMOUNT;
        for (int i = 0; i < THREADS_AMOUNT; i++) {
            int start = i * chunkSize;
            int end = (i == THREADS_AMOUNT - 1) ? PEOPLE_AMOUNT : start + chunkSize;
            List<Person> subList = people.subList(start, end);
            executor.execute(new PersonInfoPrinter(subList));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("Не все задачи завершились в отведенное время. Принудительное завершение.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Ожидание завершения задач было прервано.");
            executor.shutdownNow();
        }

        log.info("Вывод информации завершен.");
    }
}
