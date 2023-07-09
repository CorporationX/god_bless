package faang.school.godbless.sprint_3.multithreading.tamagochi_vlad;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    List<TamagotchiVlad> list = new ArrayList<>();

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
