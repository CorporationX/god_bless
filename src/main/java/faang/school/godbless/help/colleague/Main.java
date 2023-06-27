package faang.school.godbless.help.colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10000; i++) {
            String name = "Person name " + i;
            String surname = "Person surname " + i;
            String workplace = "Person workplace " + i;
            people.add(new Person(name, surname, i, workplace));
        }


        for (int i = 0; i < 5; i++) {
            int startIndex = i * 2000;
            int endIndex = startIndex + 2000;
            List<Person> batch = people.subList(startIndex, endIndex);
            PersonNamePrinter personNamePrinter = new PersonNamePrinter();
            executorService.submit(personNamePrinter);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("программа еще работает");
            } else {
                System.out.println("все готово");
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}
