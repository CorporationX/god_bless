package faang.school.godbless.HelpYourCollegue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        int listLength = 10000;
        int numberOfTreads = 5;
        int listLengthPerTread = listLength/numberOfTreads;
        for (int i = 1; i <= listLength; i++) {
            persons.add(new Person(i));
        }
        ExecutorService executor = Executors.newFixedThreadPool(numberOfTreads);
        for (int i = 0; i < numberOfTreads; i++) {
            int start = i * listLengthPerTread;
            int end = start + listLengthPerTread;
            executor.submit(new PersonNamePrinter(persons.subList(start,end)));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of program");
    }
}
