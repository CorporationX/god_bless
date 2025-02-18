package school.faang.verynicebut;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин",
                "постирать одежду", "покормить Рона"};
        ExecutorService service = Executors.newCachedThreadPool();
        for (String chore : chores) {
            service.submit(new Chore(chore));
        }
        service.shutdown();

        int second = 5;
        try {
            if (!service.awaitTermination(second, TimeUnit.SECONDS)) {
                service.shutdownNow();
                System.out.printf("Задачи не успели выполнится за %s секунд", second);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("Все задачи выполниилсь");
    }
}
