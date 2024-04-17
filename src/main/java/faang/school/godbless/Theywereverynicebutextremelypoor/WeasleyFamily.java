package faang.school.godbless.Theywereverynicebutextremelypoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {
        Chore[] chores = new Chore[]{
                new Chore("Уборка"),
                new Chore("Мытье посуды"),
                new Chore("Сказать Гарри, какоей он хороший"),
                new Chore("Припарковать машину"),
                new Chore("Найти Рона")
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executorService.execute(chore);
        }

        executorService.shutdown();
    }
}
