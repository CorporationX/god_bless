package school.faang.bjs2_89632;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WesleyFamily {
    private static final int WAITING_TIME = 5;

    private static final String[] CHORES = {
            "Помыть посуду", "Подмести пол", "Выбросить мусор",
            "Пропылесосить весь дом", "Полить цветы", "Засыпать растения огорода удобрениями",
            "Выгулять драконов", "Очень сильно ударить Рона", "Почистить мётла для полёта"
    };

    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    private WesleyFamily() {}

    public static void main(String[] args) {
        for (String choreName : CHORES) {
            EXECUTOR.submit(new Chore(choreName));
        }

        EXECUTOR.shutdown();

        try {
            if (!EXECUTOR.awaitTermination(WAITING_TIME, TimeUnit.SECONDS)) {
                log.info("Не все задачи выполнились за достаточный промежуток времени. Прерываем работу потоков...");
                EXECUTOR.shutdownNow();
            } else {
                log.info("Все задачи были выполнены вовремя!\n");
            }
        } catch (InterruptedException e) {
            log.info("Меня прервали в процессе ожидания!\n");
            Thread.currentThread().interrupt();
            EXECUTOR.shutdownNow();
        }
    }
}