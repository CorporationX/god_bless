package school.faang.bjs2_89673;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREADS = 5;
    private static final int TOTAL_PERSONS = 10000;
    private static final int AWAIT_TIME = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);

        List<Person> persons = generatePeople();

        for (int i = 0; i < THREADS; i++) {
            int start = i * (TOTAL_PERSONS / THREADS);
            int end = start + TOTAL_PERSONS / THREADS;

            List<Person> subList = persons.subList(start, end);
            PersonInfoPrinter printer = new PersonInfoPrinter(subList);
            executor.submit(printer);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TIME, TimeUnit.MINUTES)) {
                log.info("Не все задачи завершины за {} минут, принудительное закрытие пула потоков.", AWAIT_TIME);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков прервано.");
            executor.shutdownNow();
        }
        System.out.println("Все задачи выполнены.");
    }

    private static List<Person> generatePeople() {
        List<Person> persons = new ArrayList<>(Main.TOTAL_PERSONS);
        Random random = new Random();

        String[] names = {"Olga", "Anton", "Ruslan",
                "Oleg", "Anna", "Sophie", "Maksim",
                "Yana", "Andrey", "Sergey"};
        String[] surnames = {"Ivanov", "Petrov", "Sidorov",
                "Smirnov", "Kuznetsov", "Popov",
                "Vasiliev", "Sokolov", "Mikhaylov", "Novikov"};
        String[] workplaces = {"Office A", "Remote", "Headquarters",
                "Factory Floor", "Customer Support", "Research Lab",
                "Warehouse", "Sales Department", "Marketing", "Development Team"};

        for (int i = 0; i < Main.TOTAL_PERSONS; i++) {
            String name = names[random.nextInt(names.length)];
            String surname = surnames[random.nextInt(surnames.length)];
            int age = 18 + random.nextInt(60);
            String workplace = workplaces[random.nextInt(workplaces.length)];

            Person person = new Person(name, surname, age, workplace);
            persons.add(person);
        }
        return persons;
    }
}
