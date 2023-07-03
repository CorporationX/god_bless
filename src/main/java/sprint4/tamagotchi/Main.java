package sprint4.tamagotchi;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final VladController CONTROLLER = new VladController();
    private static final Runnable RUNNABLE = () -> {
        sleep();
        CONTROLLER.performAllActions();
        sleep();
        CONTROLLER.allOff();
    };
    private static final List<TamagotchiVlad> TAMAGOTCHI = List.of(
            new TamagotchiVlad(1101), new TamagotchiVlad(2052),
            new TamagotchiVlad(50505), new TamagotchiVlad(1002)
    );

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        CONTROLLER.addAll(TAMAGOTCHI);
        for (TamagotchiVlad vlad : TAMAGOTCHI) {
            service.execute(vlad::start);
        }
        service.execute(RUNNABLE);
        service.shutdown();
    }

    private static void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
