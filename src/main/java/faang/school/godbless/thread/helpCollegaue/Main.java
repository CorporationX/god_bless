package faang.school.godbless.thread.helpCollegaue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Collection<List<Person>> personListsCollection = getPersonListsCollection(generatePersons(), 100);

        for (List<Person> personList : personListsCollection) {
            executor.execute(new PersonNamePrinter(personList));
        }

        try {
            shutdown(executor);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void shutdown(ExecutorService executor) throws InterruptedException {
        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }

    private static Collection<List<Person>> getPersonListsCollection(List<Person> personList, int size) {
        AtomicInteger counter = new AtomicInteger();
        return personList.stream()
                .collect(Collectors.groupingBy(person -> counter.getAndIncrement() / size))
                .values();
    }

    private static List<Person> generatePersons() {
        List<Person> list = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            list.add(new Person("Person " + i));
        }

        return list;
    }
}
