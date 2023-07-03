package sprint4.tamagotchi;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private final List<TamagotchiVlad> tamagotchi = new ArrayList<>();

    public void performAllActions() {
        feedAll();
        playAll();
        cleanAll();
        sleepAll();
    }

    public void feedAll() {
        for (TamagotchiVlad vlad : tamagotchi) {
            vlad.feed();
        }
    }

    public void playAll() {
        for (TamagotchiVlad vlad : tamagotchi) {
            vlad.play();
        }
    }

    public void cleanAll() {
        for (TamagotchiVlad vlad : tamagotchi) {
            vlad.clean();
        }
    }

    public void sleepAll() {
        for (TamagotchiVlad vlad : tamagotchi) {
            vlad.sleep();
        }
    }

    public void allOff() {
        for (TamagotchiVlad vlad : tamagotchi) {
            vlad.turnOffForever();
        }
    }

    public void addTamagotchi(TamagotchiVlad tamagotchiVlad) {
        tamagotchi.add(tamagotchiVlad);
    }

    public void deleteTamagotchi(TamagotchiVlad tamagotchiVlad) {
        tamagotchi.remove(tamagotchiVlad);
    }

    public void addAll(List<TamagotchiVlad> tamagotchi) {
        this.tamagotchi.addAll(tamagotchi);
    }

    public void deleteAllTamagotchi() {
        tamagotchi.clear();
    }
}
