package school.faang.sprint3.task49010;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {

        List<Chore> chores = new ArrayList<>();
        chores.add(new Chore("Помыть посуду", 10));
        chores.add(new Chore("Помыть полы", 20));
        chores.add(new Chore("Вытереть пыль", 12));
        chores.add(new Chore("Выкинуть мусор", 8));
        chores.add(new Chore("Пропылесосить квартиру", 15));
        chores.add(new Chore("Убрать санузел", 20));
        chores.add(new Chore("Сходить в магазин", 30));
        chores.add(new Chore("Приготовить еду", 35));
        chores.add(new Chore("Почистить обувь", 10));

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executorService.submit(chore);
        }

        executorService.shutdown();

        try {
            // Ждём до 5 минут, пока все задачи завершатся
            if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за 5 минут, принудительно останавливаем...");
                executorService.shutdownNow();  // Принудительное завершение, если задачи зависли
            }
        } catch (InterruptedException e) {
            // Если главный поток был прерван во время ожидания, принудительно останавливаем пул
            executorService.shutdownNow();
        }
    }
}
