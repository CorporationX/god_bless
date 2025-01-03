package faang.school.godbless.ThirdSprint.BJS2_48288;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {

    final static Logger logger = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Person> first = new ArrayList<>(500);
        List<Person> second = new ArrayList<>(500);
        List<Person> third = new ArrayList<>(500);

        for (int i = 0; i < 500; i++) {
            first.add(new Person("name #" + i, "surname #" + i, i % 50, "workspace #" + i));
            second.add(new Person("name #" + i, "surname #" + i, i % 50, "workspace #" + i));
            third.add(new Person("name #" + i, "surname #" + i, i % 50, "workspace #" + i));
        }
        first.forEach(a -> service.submit(new PersonInfoPrinter(a)));
        second.forEach(a -> service.submit(new PersonInfoPrinter(a)));
        third.forEach(a -> service.submit(new PersonInfoPrinter(a)));

        service.shutdown();
        try {
            while (!service.awaitTermination(5, TimeUnit.SECONDS)) {}
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("Work is done!");

    }
}
