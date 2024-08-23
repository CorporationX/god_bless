package faang.school.godbless.VladTamagochi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        VladController vladController;
        List<TamagochiVlad> vlads = new ArrayList<TamagochiVlad>();
        vlads.add(new TamagochiVlad("masha", 60, 55, 40, 45));
        vlads.add(new TamagochiVlad("ivan", 45, 65, 35, 50));
        vlads.add(new TamagochiVlad("olga", 70, 50, 45, 55));
        vlads.add(new TamagochiVlad("nikita", 55, 60, 50, 40));
        vlads.add(new TamagochiVlad("anya", 40, 45, 60, 65));
        vlads.add(new TamagochiVlad("sergey", 65, 70, 55, 60));
        vladController = new VladController(vlads);

        vlads.add(new TamagochiVlad("valera", 50, 40, 30, 20));
        for (int i = 0; i < 2; i++) {
            executorService.execute(() -> {
                vladController.cleanseAll();
                vladController.feedAll();
                vladController.playWithAll();
                vladController.restAll();
            });
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.HOURS)) {
                executorService.shutdownNow();
                System.out.println("terminated");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
