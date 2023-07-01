package faang.school.godbless.sprint_3.multithreading.tamagochi_vlad;

import java.util.HashSet;
import java.util.Set;

public class VladController {
    Set<TamagotchiVlad> list = new HashSet<>();

    public synchronized void addVlad(TamagotchiVlad tamagotchi) {
        list.add(tamagotchi);

    }

    public synchronized void removeVlad(TamagotchiVlad tamagotchi) {
        list.remove(tamagotchi);
    }

    public synchronized void feedAll() {
        list.forEach(TamagotchiVlad::feed);
    }

    public synchronized void playAll() {
        list.forEach(TamagotchiVlad::play);
    }

    public synchronized void cleanAll() {
        list.forEach(TamagotchiVlad::clean);
    }

    public synchronized void sleepAll() {
        list.forEach(TamagotchiVlad::sleep);
    }
}
