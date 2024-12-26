package school.faang.task48100;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


@Slf4j
public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        IntStream.range(0, 10000)
                .forEach(i -> persons.add(Person.builder()
                        .name("name" + i)
                        .surname("Surname" + i)
                        .age(i)
                        .workplace("workplace" + i)
                        .build()));


        int numThreads = 5;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<List<Person>> people = ListUtils.partition(persons, 5);

        for (int i = 0; i < numThreads; i++) {
            List<Person> currentPartition = people.get(i);
            executor.submit(new PersonInfoPrinter(currentPartition));
        }

//        int batchSize = persons.size() / numThreads;
//        for (int i = 0; i < numThreads; i++) {
//            int start = i * batchSize;
//            int end = (i == numThreads - 1) ? persons.size() : (i + 1) * batchSize;
//
//            List<Person> batch = persons.subList(start, end);
        //   batch.forEach(personList -> executor.submit(new PersonInfoPrinter(personList)));
//
//        }
        executor.shutdown();

        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("Work is done .");
            } else {
                log.info("Work is not done!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
