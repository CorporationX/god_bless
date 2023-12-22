package extremelyPoor_1030;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {

        String[] chores = {"Уборка", "Стирка", "Глажка", "Мытье окон"};
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executorService.execute(new Chore(chore));
        }
        executorService.shutdown();
    }
}