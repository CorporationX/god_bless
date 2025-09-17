package school.faang.bjs2_89632;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class WesleyFamily {
    private static final String[] CHORES = {
            "Помыть посуду", "Подмести пол", "Выбросить мусор",
            "Пропылесосить весь дом", "Полить цветы", "Засыпать растения огорода удобрениями",
            "Выгулять драконов", "Очень сильно ударить Рона", "Почистить мётла для полёта"
    };

    private static final ExecutorService EXECUTORS = Executors.newCachedThreadPool();

    private WesleyFamily() {}

    public static void main(String[] args) {
        for (String choreName : CHORES) {
            EXECUTORS.submit(new Chore(choreName));
        }

        EXECUTORS.shutdown();

        try {
            if (!EXECUTORS.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println(
                        "Не все задачи выполнились за достаточный промежуток времени. Прерываем работу потоков..."
                );
                EXECUTORS.shutdownNow();
            } else {
                System.out.printf("%s: Все задачи были выполнены вовремя!\n", Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            System.out.printf("%s: Меня прервали в процессе ожидания!\n", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}