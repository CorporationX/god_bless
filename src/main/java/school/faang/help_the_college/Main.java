package school.faang.help_the_college;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int STREAM_ACCOUNT = 20;

    public static void main(String[] args) {

        Faker faker = new Faker();
        List<Person> company = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String workplace = faker.company().name();

            company.add(new Person(firstName, lastName, 20, workplace));

        }
        System.out.println("Создано персон в компании: " + company.size());

        ExecutorService executorService = Executors.newFixedThreadPool(STREAM_ACCOUNT);
        int batchSize = company.size() / STREAM_ACCOUNT;
        for (int i = 0; i < STREAM_ACCOUNT; i++) {
            int fromIndex = i * batchSize;
            int toIndex = (i == STREAM_ACCOUNT - 1) ? company.size() : (i + 1) * batchSize;

            List<Person> subList = company.subList(fromIndex, toIndex);

            executorService.execute(new PersonInfoPrinter(subList));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.err.println("Не все задачи завершились за отведенное время. Принудительное завершение.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Работа была прервана. Принудительное завершение.");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Все потоки завершили работу. Программа завершена.");
    }
}
