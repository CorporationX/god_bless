package faang.school.godbless.alexbulgakoff.multithreading.parallelism.helpacolleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Bulgakov
 */

public class Main {

    static final int COUNT_THREADS = 5;
    static final int COUNT_PERSONS = 10_000;
    static final int CHUNK = COUNT_PERSONS / COUNT_THREADS;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREADS);
        List<Person> personList = new ArrayList<>(COUNT_PERSONS);

        // Заполнение на 10 тысяч персон
        for (int i = 0; i < COUNT_PERSONS; i++) {
            personList.add(new Person(String.valueOf(i)));
        }
        // Разбивка по листам на 2000 персон
        List<List<Person>> chunks = Main.chunkingList(personList, CHUNK);

        for (List<Person> people : chunks) {
            executorService.submit(new PersonNamePrinter(people));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println("Вывод имен завершен!");
    }

    public static <T> List<List<T>> chunkingList(List<T> list, int chunkSize){
        List<List<T>> chunks = new ArrayList<>();

        for (int i = 0; i < list.size(); i += chunkSize) {
            List<T> chunk = new ArrayList<>(list.subList(i, Math.min(list.size(), i + chunkSize)));
            chunks.add(chunk);
        }

        return chunks;
    }
}
