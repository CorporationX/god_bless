package faang.school.godbless.BJS224341;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VladController {
    private final List<TamagotchiVlad> tamagotchiList = Collections.synchronizedList(new ArrayList<>());

    public synchronized void addTamagotchi(TamagotchiVlad tamagotchi) {
        synchronized (tamagotchiList) {
            tamagotchiList.add(tamagotchi);
            System.out.println(tamagotchi.getName() + " is added");
        }
    }

    public synchronized void removeTamagotchi(TamagotchiVlad tamagotchi) {
        synchronized (tamagotchiList) {
            tamagotchiList.remove(tamagotchi);
            System.out.println(tamagotchi.getName() + " is removed");
        }
    }

    public synchronized void feedAll() {
        synchronized (tamagotchiList) {
            tamagotchiList.forEach(TamagotchiVlad::feed);
        }
    }

    public synchronized void playAll() {
        synchronized (tamagotchiList) {
            tamagotchiList.forEach(TamagotchiVlad::play);
        }
    }

    public synchronized void cleanAll() {
        synchronized (tamagotchiList) {
            tamagotchiList.forEach(TamagotchiVlad::clean);
        }
    }

    public synchronized void sleepAll() {
        synchronized (tamagotchiList) {
            tamagotchiList.forEach(TamagotchiVlad::sleep);
        }
    }
}
