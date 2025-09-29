package school.faang.thread_pool;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * Проект: god_bless
 * Класс WeasleyFamily
 * Автор: Vital
 */

public class WeasleyFamily {
    private final String[] chores;

    public WeasleyFamily(String[] chores) {
        this.chores = chores;
    }

    public void performChores() {
        ExecutorService executor = Executors.newCachedThreadPool();

        Arrays.stream(chores)
                .filter(Objects::nonNull)       //фильтруем null
                .map(String::strip)              //убираем пробелы
                .filter(s -> !s.isEmpty())      //фильтруем пустые строки
                .map(Chore::new)                //создаем Chore
                .forEach(executor::execute);    //запускаем задачи в пуле

        //Завершаем работу пула
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}