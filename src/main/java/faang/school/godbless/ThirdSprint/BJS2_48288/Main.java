package faang.school.godbless.ThirdSprint.BJS2_48288;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        List<Person> firstList = new ArrayList<>();
        List<Person> secondList = new ArrayList<>();
        List<Person> thirdList = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            firstList.add(new Person("name #" + i, "surname #" + i, i % 50, "workspace #" + i));
            secondList.add(new Person("name #" + i, "surname #" + i, i % 50, "workspace #" + i));
            thirdList.add(new Person("name #" + i, "surname #" + i, i % 50, "workspace #" + i));
        }
        firstList.stream().forEach(a -> service.submit(new PersonInfoPrinter(a)));
        secondList.stream().forEach(a -> service.submit(new PersonInfoPrinter(a)));
        thirdList.stream().forEach(a -> service.submit(new PersonInfoPrinter(a)));

        service.shutdown();
        try {
            while (true) {
                if (service.awaitTermination(5, TimeUnit.SECONDS)) break;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Work is done!");
    }
}
