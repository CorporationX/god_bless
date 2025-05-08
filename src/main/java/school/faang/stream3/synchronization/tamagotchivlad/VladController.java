package school.faang.stream3.synchronization.tamagotchivlad;

import lombok.Getter;
import java.util.concurrent.CopyOnWriteArrayList;

public class VladController implements Runnable {
    @Getter
    private CopyOnWriteArrayList<TamagotchiVlad> tamagotchiList = new CopyOnWriteArrayList<>();

    public void createTamagotchi(String name) {
        tamagotchiList.add(new TamagotchiVlad(name));
    }

    @Override
    public void run() {
        while (tamagotchiList
                .stream().anyMatch(tamagotchiVlad -> tamagotchiVlad.getIsAlive().get())) {
            System.out.println("Time is running");
            for (TamagotchiVlad tamagotchi :
                    tamagotchiList
                            .stream()
                            .filter(tamagotchiVlad -> tamagotchiVlad.getIsAlive().get())
                            .toList()) {
                try {
                    tamagotchi.run();
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void feedAll() {
        for (TamagotchiVlad tamagotchi : tamagotchiList) {
            tamagotchi.feed();
        }
    }

    public void playAll() {
        for (TamagotchiVlad tamagotchi : tamagotchiList) {
            tamagotchi.play();
        }
    }

    public void cleanAll() {
        for (TamagotchiVlad tamagotchi : tamagotchiList) {
            tamagotchi.clean();
        }
    }

    public void sleepAll() {
        for (TamagotchiVlad tamagotchi : tamagotchiList) {
            tamagotchi.sleep();
        }
    }
}
