package faang.school.godbless.nicebutpoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"уборка в доме",
                "стирка белья",
                "готовка еды",
                "работа в саду",
                "покупка продуктов",
                "уборка в комнате Рона",
                "починка часов",
                "подготовка уроков"};
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }
        executor.shutdown();
    }
}
