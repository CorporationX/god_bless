package school.faang.bjs248219;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int THREAD_SiZE = 5;

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        for (int i = 1; i <= 10_000; i++) {
            people.add(new Person("Test " + i, "Testov " + i, i, "IT " + i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_SiZE);

        int batch = people.size() / THREAD_SiZE;
        for (int i = 0; i < THREAD_SiZE; i++) {
            int start = i * batch;
            int end = i == (THREAD_SiZE - 1) ? people.size() : (i + 1) * batch;
            PersonInfoPrinter printer = new PersonInfoPrinter(people.subList(start, end));
            executor.submit(printer);
        }

        executor.shutdown();
    }

}
