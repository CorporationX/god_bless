package school.faang.sprint.third.tamagochi;

import java.util.List;
import java.util.Random;

public class VladController {
    private static final Random RANDOM = new Random();

    public void feedAll(List<TamagotchiVlad> tamagotchiVlads) {
        tamagotchiVlads.forEach(tamagotchiVlad -> {
            tamagotchiVlad.feed();
            try {
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    public void playAll(List<TamagotchiVlad> tamagotchiVlads) {
        tamagotchiVlads.forEach(tamagotchiVlad -> {
            tamagotchiVlad.play();
            try {
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    public void cleanAll(List<TamagotchiVlad> tamagotchiVlads) {
        tamagotchiVlads.forEach(tamagotchiVlad -> {
            tamagotchiVlad.clean();
            try {
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    public void sleepAll(List<TamagotchiVlad> tamagotchiVlads) {
        tamagotchiVlads.forEach(tamagotchiVlad -> {
            tamagotchiVlad.sleep();
            try {
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}
