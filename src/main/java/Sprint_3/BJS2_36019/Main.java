package Sprint_3.BJS2_36019;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i < 10000; i++) {
            String name = i + "имя";
            String surname = i + "Фамилия";
            String workplace = i + "Место работы";
            persons.add(new Person(name, surname, workplace));
        }
        PersonInfoPrinter printer = new PersonInfoPrinter(persons);

        int numThreads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        // Размер части списка для каждого потока
        int partitionSize = persons.size() / numThreads;

        //Разделение списка на части и выполнение каждой части в отдельном потоке

        for (int i = 0; i < numThreads; i++) {
            int fromIndex = i * partitionSize;
            int toIndex = (i == numThreads - 1) ? persons.size() : (i + 1) * partitionSize; // Последний поток забирает остаток

            List<Person> sublist = persons.subList(fromIndex, toIndex);
            executorService.submit(new PersonInfoPrinter(sublist));
        }
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

    }
}
