package school.faang.stream3.synchronization.tamagotchivlad;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class VladController implements Runnable {
    @Getter
    private List<TamagotchiVlad> tamagotchiList = new ArrayList<>();

    public void createTamagotchi(String name) {
        tamagotchiList.add(new TamagotchiVlad(name));
    }

    @Override
    public void run() {
        while (!tamagotchiList.isEmpty()) {
            System.out.println("Time is running");
            for (TamagotchiVlad tamagotchi : tamagotchiList) {
                try {
                    tamagotchi.run();
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    tamagotchiList.remove(new TamagotchiVlad(e.getMessage().split("for ")[1]));
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
