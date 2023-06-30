package tamagochi_vlad;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VladController {
    private final List<TamagotchiVlad> tamagotchis;

    public VladController() {
        tamagotchis = new CopyOnWriteArrayList<>();
    }

    public void addTamagotchi(TamagotchiVlad tamagotchi) {
        tamagotchis.add(tamagotchi);
    }

    public void removeTamagotchi(TamagotchiVlad tamagotchi) {
        tamagotchis.remove(tamagotchi);
    }

    public synchronized void feedAll() {
        tamagotchis.forEach(TamagotchiVlad::feed);
    }

    public synchronized void playAll() {
        tamagotchis.forEach(TamagotchiVlad::play);
    }

    public synchronized void cleanAll() {
        tamagotchis.forEach(TamagotchiVlad::clean);
    }

    public synchronized void sleepAll() {
        tamagotchis.forEach(TamagotchiVlad::sleep);
    }
}
