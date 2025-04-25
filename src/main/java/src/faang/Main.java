package src.faang;

import lombok.extern.slf4j.Slf4j;
import src.faang.model.Person;
import src.faang.service.PersonInfoPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Slf4j
public class Main {
    private static final String[] NAMES = {"Алексей", "Мария", "Иван", "Анна", "Дмитрий", "Елена"};
    private static final String[] JOBS = {"Разработчик", "Врач", "Учитель", "Инженер", "Дизайнер"};
    private static final String[] SURNAME = {"Test1", "Test2", "Test3", "Test4", "Test5", "Test6"};
    private static final int MAX_AGE_BOUND = 100;

    private static final int PEOPLE_COUNT = 10_000;
    private static final int THREADS_COUNT = 10;

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        final List<Person> people = generatePeople(PEOPLE_COUNT);
        final List<List<Person>> dividedPeople = dividePeople(people);
        final ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

        for (int i = 0; i < THREADS_COUNT; i++) {
            executorService.execute(new PersonInfoPrinter(dividedPeople.get(i)));
        }

        shutdownAndAwaitTermination(executorService);
        log.info("Работа программы завершена.");
    }

    private static void shutdownAndAwaitTermination(ExecutorService executorService) {
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
    }

    private static List<List<Person>> dividePeople(List<Person> people) {
        final List<List<Person>> dividedPeople = new ArrayList<>();
        final List<Person> partDividedPeople = new ArrayList<>();

        for (int i = 0; i < PEOPLE_COUNT; i++) {
            partDividedPeople.add(people.get(i));

            if (partDividedPeople.size() % (PEOPLE_COUNT / THREADS_COUNT) == 0) {
                dividedPeople.add(new ArrayList<>(partDividedPeople));
                partDividedPeople.clear();
            }
        }

        return dividedPeople;
    }

    private static List<Person> generatePeople(int count) {
        return Stream.generate(() -> new Person(
                NAMES[RANDOM.nextInt(NAMES.length)],
                SURNAME[RANDOM.nextInt(SURNAME.length)],
                RANDOM.nextInt(MAX_AGE_BOUND),
                JOBS[RANDOM.nextInt(JOBS.length)]
        )).limit(count).toList();
    }
}

