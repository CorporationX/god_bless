package faang.school.godbless.sprint_3.multithreading.colleague_help;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String name = "Person" + i;
            String surname = "Surname" + i;
            String workplace = "Workplace" + i;
            personList.add(new Person(name, surname, i, workplace));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 2000;
            int lastIndex = (i + 1) * 2000;
            List<Person> parts = personList.subList(startIndex, lastIndex);
            executorService.submit(new PersonNamePrinter(parts));
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Все задачи выполнены!");
            } else {
                System.out.println("Еще есть задачи в выполнении");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
