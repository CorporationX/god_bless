import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newFixedThreadPool;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            Person person = new Person("Name-" + i, "Surname-" + i, i, "Workplace-" + i);
            personList.add(person);
        }

        ExecutorService executor = newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {

            PersonNamePrinter personNamePrinter = new PersonNamePrinter(personList.subList(i * 1000, 1000 * (i + 1)));
            executor.submit(personNamePrinter);

        }

        executor.awaitTermination(3, TimeUnit.SECONDS);
        executor.shutdownNow();
        System.out.println("Программа выполнена");
    }
}
