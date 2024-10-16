package weasley.family;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {
                "Создать крестраж из семейного портрета для Молли",
                "Перекрасить волосы у близнецов Фреда и Джорджа в белый цвет",
                "Заложить Форд Англия, чтобы купить что-то в магазине Горбин и Бэркес",
                "Устроить Артура Уизли помощником Волан-Де-Морта"
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String toDo : chores) {
            Chore chore = new Chore(toDo);

            executorService.execute(chore);
        }

        executorService.shutdown();


        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                System.err.println("Останавливаю пул потоков: задачи не завершились вовремя");
            } else {
                System.out.println("Задачи выполнены успешно");
            }

        } catch (InterruptedException error) {
            executorService.shutdown();
            Thread.currentThread().interrupt();
            System.err.println("Головной поток прервался");
        }
    }
}
