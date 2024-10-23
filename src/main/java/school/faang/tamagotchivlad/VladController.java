package school.faang.tamagotchivlad;

import lombok.Synchronized;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private final List<TamagotchiVlad> tamagotchiList = new ArrayList<>();

    @Synchronized
    public void addTamagotchi(TamagotchiVlad tamagotchi) {
        tamagotchiList.add(tamagotchi);
        System.out.println(tamagotchi.getName() + " has been added.");
    }

    @Synchronized
    public void removeTamagotchi(TamagotchiVlad tamagotchi) {
        tamagotchiList.remove(tamagotchi);
        System.out.println(tamagotchi.getName() + " has been removed.");
    }

    public void feedAll() {
        tamagotchiList.parallelStream().forEach(TamagotchiVlad::feed);
    }

    public void playAll() {
        tamagotchiList.parallelStream().forEach(TamagotchiVlad::play);
    }

    public void cleanAll() {
        tamagotchiList.parallelStream().forEach(TamagotchiVlad::clean);
    }

    public void sleepAll() {
        tamagotchiList.parallelStream().forEach(TamagotchiVlad::sleep);
    }
}

