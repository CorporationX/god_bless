package faang.school.godbless.BJS224341;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VladController {
    private final List<TamagotchiVlad> tamagotchiList = Collections.synchronizedList(new ArrayList<>());

    public void addTamagotchi(TamagotchiVlad tamagotchi) {
        synchronized (tamagotchiList) {
            tamagotchiList.add(tamagotchi);
            System.out.println(tamagotchi.getName() + " is added");
        }
    }

    public void removeTamagotchi(TamagotchiVlad tamagotchi) {
        synchronized (tamagotchiList) {
            tamagotchiList.remove(tamagotchi);
            System.out.println(tamagotchi.getName() + " is removed");
        }
    }

    public void feedAll() {
        synchronized (tamagotchiList) {
            tamagotchiList.forEach(TamagotchiVlad::feed);
        }
    }

    public void playAll() {
        synchronized (tamagotchiList) {
            tamagotchiList.forEach(TamagotchiVlad::play);
        }
    }

    public void cleanAll() {
        synchronized (tamagotchiList) {
            tamagotchiList.forEach(TamagotchiVlad::clean);
        }
    }

    public void sleepAll() {
        synchronized (tamagotchiList) {
            tamagotchiList.forEach(TamagotchiVlad::sleep);
        }
    }
}
