package school.faang.sprint1.task_48064;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int sizeThread = 6;
        List<Person> persons = createPerson(10000);

        ExecutorService executor = Executors.newFixedThreadPool(sizeThread);
        int batchSize = persons.size() / sizeThread;
        for (int i = 0; i < sizeThread; i++) {
            int start = i * batchSize;
            int end = (i == sizeThread - 1) ? persons.size() : (i + 1) * batchSize;
            List<Person> batch = persons.subList(start, end);
            executor.submit(new PersonInfoPrinter(batch));
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Все задачи завершены");
            } else {
                System.out.println("Задача прервана");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Person> createPerson(int size) {
        List<Person> addPerson = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            addPerson.add(new Person("Name" + i, "Surnsme"
                    + i, 25 + (i % 50), "Workplace" + i));
        }
        return addPerson;
    }

}
