package school.faang.BJS236658;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        List<String> weasleyFamily = List.of("помыть посуду", "подмести пол", "приготовить ужин");

        ExecutorService service = Executors.newCachedThreadPool();
        for (String chore : weasleyFamily) {
            service.submit(new Chore(chore));
        }
        service.shutdown();
        try {
            if (!service.awaitTermination(25, TimeUnit.SECONDS)) {
                System.out.println("Уборка не была завершена, провал!");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Остановка главного потока.");
            e.printStackTrace();
            service.shutdownNow();
        }
    }
}
