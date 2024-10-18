package school.faang.task318;

import school.faang.task318.person.Person;
import school.faang.task318.person.PersonInfoPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person("Name" + i, "Surname" + i, 18 + (i / 120), "work" + i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(4);
        final int listSize = 2500;

        for (int i = 0; i < 4; i++) {
            executor.submit(new PersonInfoPrinter(persons.subList(i * listSize, (i + 1) * listSize)));
        }

        executor.shutdown();
        if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("Ошибка, не вся информация была выведена");
            executor.shutdownNow();
        } else {
            System.out.println("Вся информация успешно выведена!");
        }
    }
}
