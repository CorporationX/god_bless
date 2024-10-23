package school.faang.tamagochi;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private final List<TamagotchiVlad> tamagotchiVlads = new ArrayList<>();

    public synchronized void addVlad(TamagotchiVlad vlad) {
        tamagotchiVlads.add(vlad);
    }

    public synchronized void removeVlad(TamagotchiVlad vlad) {
        tamagotchiVlads.remove(vlad);
    }

    public void feedAll() {
        tamagotchiVlads.forEach(TamagotchiVlad::feed);
    }

    public void playAll() {
        tamagotchiVlads.forEach(TamagotchiVlad::play);
    }

    public void cleanAll() {
        tamagotchiVlads.forEach(TamagotchiVlad::clean);
    }

    public void sleepAll() {
        tamagotchiVlads.forEach(TamagotchiVlad::sleep);
    }
}
