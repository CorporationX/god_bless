package school.faang.BJS2_60461;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        final Knight firstKnight = new Knight("Ричард Лунный Меч");
        final Knight secondKnight = new Knight("Сэр Артур фон Драконхарт");

        firstKnight.addTrial(new Trial(firstKnight.getName(), "Пройти через огненную долину"));
        firstKnight.addTrial(new Trial(firstKnight.getName(), "Пересечь бурлящую реку"));
        firstKnight.addTrial(new Trial(firstKnight.getName(), "Подняться на гору против ветра"));

        secondKnight.addTrial(new Trial(secondKnight.getName(), "Пробраться через пещеры с ловушками"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "Разгадать три загадки мага"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "Сразиться с чудовищем"));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        firstKnight.startTrials(executor);
        secondKnight.startTrials(executor);
        executor.shutdown();
    }
}
