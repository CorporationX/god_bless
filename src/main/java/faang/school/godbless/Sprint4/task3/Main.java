package faang.school.godbless.Sprint4.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            personList.add(new Person());
        }

        int countOfThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(countOfThreads);

        int onePartOfList = personList.size() / countOfThreads;

        for (int i = 0; i < countOfThreads; i++) {
            int startIndex = i * onePartOfList;
            int endIndex = startIndex + onePartOfList;
            List<Person> partOfList = personList.subList(startIndex, endIndex);

            for (Person person : partOfList) {
                executor.execute(new PersonNamePrinter(person));
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Workplace info have been sent");
    }
}
