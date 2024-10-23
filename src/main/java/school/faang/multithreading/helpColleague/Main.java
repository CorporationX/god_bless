package school.faang.multithreading.helpColleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = new ArrayList<>();
        int threadNum = 5;

        for (int i = 0; i < 10000; i++) {
            persons.add(new Person("name" + i, "surname" + i, i, "workplace" + i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(threadNum);

        for (int i = 0; i < threadNum; i++) {
            int batchSize = persons.size()/threadNum;
            int beginIndex = i*batchSize;
            int endIndex = (i == threadNum - 1) ? persons.size() : (i + 1) * batchSize;
            List<Person> personSublist = persons.subList(beginIndex, endIndex);

            PersonInfoPrinter printer = new PersonInfoPrinter(personSublist);
            executor.submit(printer);
        }
        executor.shutdown();
        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("Все задачи успешно завершены");
        } else {
            System.out.println("Задачи не были выполнены полностью");
        }



    }
}
