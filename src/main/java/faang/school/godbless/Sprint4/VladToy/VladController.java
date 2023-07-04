package faang.school.godbless.Sprint4.VladToy;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VladController {
    List<TamagotchiVlad> tamagotchies = new LinkedList<>();
    ExecutorService executors = Executors.newFixedThreadPool(2);

    public void addTamagotchi(TamagotchiVlad tamagotchi) {
        tamagotchies.add(tamagotchi);
    }

    public void removeTamagotchi(TamagotchiVlad tamagotchi) {
        tamagotchies.remove(tamagotchi);
    }

    public void feedAll() {
        for (TamagotchiVlad tamagotchi : tamagotchies) {
            executors.execute(() -> {
                try {
                    tamagotchi.feed();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });
        }
    }

    public void playAll() {
        for (TamagotchiVlad tamagotchi : tamagotchies) {
            executors.execute(() -> {
                try {
                    tamagotchi.play();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });
        }
    }

    public void cleanAll() {
        for (TamagotchiVlad tamagotchi : tamagotchies) {
            executors.execute(() -> {
                try {
                    tamagotchi.clean();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });
        }
    }

    public void sleepAll() {
        for (TamagotchiVlad tamagotchi : tamagotchies) {
            executors.execute(() -> {
                try {
                    tamagotchi.sleep();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });
        }
    }

    public void executorsEnd() {
        executors.shutdown();
    }
}
