package faang.school.godbless.help_a_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = new ArrayList<>();
        for(int i = 0; i < 10000; i++) {
            String name = "Person" + i;
            Person person = new Person(name, "Vazikov", 60, "TSU");
            persons.add(person);
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(int j = 0; j < 5; j++) {
            List<Person> sublist = persons.subList(j*2000, j*2000 + 2000);
            PersonNamePrinter printer = new PersonNamePrinter(sublist);
            executor.submit(() -> printer.run());
        }
        executor.shutdown();

        boolean isDone = executor.awaitTermination(2, SECONDS);
        System.out.println("Are all tasks completed? - " + isDone);
        }
    }
