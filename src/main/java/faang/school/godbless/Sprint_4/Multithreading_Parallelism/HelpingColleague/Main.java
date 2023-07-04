package faang.school.godbless.Sprint_4.Multithreading_Parallelism.HelpingColleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = new ArrayList<>(); // 10 000 people
        for(int i = 0; i < 10000; ++i) {
            persons.add(new Person(i));
        }
        int threads = persons.size() / 1000;
        if(threads == 0 && persons.size() > 0) threads = 1;
        ExecutorService executor = newFixedThreadPool(threads);
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < threads; ++i) {
            if(i + 1 == threads) {
                endIndex = persons.size();
                List<Person> batch = persons.subList(startIndex, endIndex);
                executor.submit(new PersonNamePrinter(batch));
            } else {
                endIndex = startIndex + 1000;
                List<Person> batch = persons.subList(startIndex, endIndex);
                executor.submit(new PersonNamePrinter(batch));
                startIndex = endIndex;
            }
        }
        executor.awaitTermination(3000, TimeUnit.MILLISECONDS);
        executor.shutdown();
        System.out.println("Program finished");
    }
}
