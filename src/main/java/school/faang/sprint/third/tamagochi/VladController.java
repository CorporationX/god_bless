package school.faang.sprint.third.tamagochi;

import java.util.List;
import java.util.Random;

public class VladController {
    private static final int THREAD_SLEEP_TIME = 10000;
    private static final Random RANDOM = new Random();

    public void feedAll(List<TamagotchiVlad> tamagotchiVlads) {
        tamagotchiVlads.forEach(tamagotchiVlad -> {
            tamagotchiVlad.feed();
            threadSleep();
        });
    }

    public void playAll(List<TamagotchiVlad> tamagotchiVlads) {
        tamagotchiVlads.forEach(tamagotchiVlad -> {
            tamagotchiVlad.play();
            threadSleep();
        });
    }

    public void cleanAll(List<TamagotchiVlad> tamagotchiVlads) {
        tamagotchiVlads.forEach(tamagotchiVlad -> {
            tamagotchiVlad.clean();
            threadSleep();
        });
    }

    public void sleepAll(List<TamagotchiVlad> tamagotchiVlads) {
        tamagotchiVlads.forEach(tamagotchiVlad -> {
            tamagotchiVlad.sleep();
            threadSleep();
        });
    }

    private void threadSleep() {
        try {
            Thread.sleep(RANDOM.nextInt(THREAD_SLEEP_TIME));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
