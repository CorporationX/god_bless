package faang.school.godbless.helpCollegue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            int a = i%20;
            people.add(new Person(i + "-й сотрудник", "20", 25, a + "-й отдел"));
        }

        ExecutorService service = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            service.submit(new PersonNamePrinter(people.subList(i*250, i*250+249)));
        }
        service.shutdown();
        try {
            if(service.awaitTermination(10, TimeUnit.MILLISECONDS))
            System.out.println("Программа завершена!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
