package faang.school.godbless.collegueHelp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String... args) throws InterruptedException {
        List<Person> persons = new ArrayList<>();
        int sizeOfPersonList = 10000;
        for (int i = 0; i < sizeOfPersonList; i++){
            persons.add(new Person(String.valueOf(i), String.valueOf(i), i, String.valueOf(i)));
        }
        int threadsCount = 5;
        ExecutorService executors = Executors.newFixedThreadPool(threadsCount);
        List<PersonNamePrinter> printers = new ArrayList<>();
        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * (sizeOfPersonList / threadsCount);
            int endIndex = startIndex + (sizeOfPersonList / threadsCount);
            List<Person> batch = persons.subList(startIndex, endIndex);
            printers.add(new PersonNamePrinter(batch));
        }
        for (PersonNamePrinter printer : printers) {
            executors.submit(printer);
        }
        executors.shutdown();
        if (!executors.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
            System.out.println("Something wrong!");
        }
        System.out.println("All done");
    }
}
