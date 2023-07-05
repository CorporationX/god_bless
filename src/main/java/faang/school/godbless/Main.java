package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            personList.add(new Person("Person" + i, "surname", 30, "workplace"));
        }
        ExecutorService executor = Executors.newFixedThreadPool(4);

        PersonNamePrinter printer1 = new PersonNamePrinter(0,2500);
        PersonNamePrinter printer2 = new PersonNamePrinter(2500,5000);
        PersonNamePrinter printer3 = new PersonNamePrinter(5000,7500);
        PersonNamePrinter printer4 = new PersonNamePrinter(7500,10000);

        executor.submit(printer1);
        executor.submit(printer2);
        executor.submit(printer3);
        executor.submit(printer4);

        executor.shutdown();

        boolean isDone = executor.awaitTermination(2, SECONDS);
        System.out.println("Program complete all tasks ? - " + isDone);

