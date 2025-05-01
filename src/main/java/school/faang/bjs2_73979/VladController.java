package school.faang.bjs2_73979;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private final List<TamagotchiVlad> tamagotchis = new ArrayList<>();

    public synchronized boolean addVlad(TamagotchiVlad tamagotchiVlad) {
        return tamagotchis.add(tamagotchiVlad);
    }

    public synchronized boolean removeVlad(TamagotchiVlad tamagotchiVlad) {
        return tamagotchis.remove(tamagotchiVlad);
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