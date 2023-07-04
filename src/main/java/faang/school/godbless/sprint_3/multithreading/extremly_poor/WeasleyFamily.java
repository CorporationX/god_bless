package faang.school.godbless.sprint_3.multithreading.extremly_poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = new String[]{"Эвакуация!", "Внимание опасность!", "Выдача зарплат!", "Загрузка кофе!", "Выделения памяти!"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String stroke : chores) {
            Chore chore = new Chore(stroke);
            executorService.submit(chore);
        }
        executorService.shutdown();
    }
}
