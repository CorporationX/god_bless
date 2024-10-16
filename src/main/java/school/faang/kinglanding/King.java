package school.faang.kinglanding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) throws InterruptedException {
        List<Knight> knightList = new ArrayList<>();
        Knight artur = new Knight("Knight Arthur");
        Knight lancelot = new Knight("Knight lancelot");

        Trial trial1 = new Trial("Knight Arthur", "Trial of Courage");
        Trial trial2 = new Trial("Knight Arthur", "Trial of Wisdom");
        Trial trial3 = new Trial("Knight lancelot", "Trial of Strength");
        Trial trial4 = new Trial("Knight lancelot", "Trial of Agility");

        artur.addTrial(trial1);
        artur.addTrial(trial2);
        lancelot.addTrial(trial3);
        lancelot.addTrial(trial4);
        knightList.add(artur);
        knightList.add(lancelot);

        ExecutorService service = Executors.newFixedThreadPool(2);

        knightList.forEach(k -> {
            if (k.getTrials().isEmpty()) {
                throw new RuntimeException("Список испытаний пуст");
            }
            k.startTrials(service);
        });

        service.shutdown();

        if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("\nВремя ожидания истекло. Завершение работы сервисов.");
            service.shutdownNow();
        }
    }
}
