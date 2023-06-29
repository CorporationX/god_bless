package faang.school.godbless.Help.colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < 10_000; i++) {
            personList.add(new Person(i + "", i + "", i, i + ""));
        }

        ExecutorService threads = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            Optional<List<Person>> list = Optional.of(new ArrayList<>(personList.subList(i * 1000, ++i * 1000)));

            list.stream().forEach(l -> threads.submit(new PersonNamePrinter(l)));
        }

        threads.shutdown();

        threads.awaitTermination(500, TimeUnit.MILLISECONDS);

        System.out.println("На этом мои полномочия всё!");
    }
}
