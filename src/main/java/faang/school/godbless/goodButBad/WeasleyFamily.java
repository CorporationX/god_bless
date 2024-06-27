package faang.school.godbless.goodButBad;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {
                "Приготовление еды",
                "Уборка комнаты",
                "Мытье посуды",
                "Полив растений",
                "Покупка продуктов"
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        for(String chore : chores) {
            Chore choreTask = new Chore(chore);
            executorService.execute(choreTask);
        }

        executorService.shutdown();
    }
}
