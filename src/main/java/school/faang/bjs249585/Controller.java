package school.faang.bjs249585;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Controller {
    private final List<Tamagotchi> tamagotchis = new ArrayList<>();

    public void addTamagochi() {
        Tamagotchi tamagotchi = new Tamagotchi();
        tamagotchis.add(tamagotchi);
    }

    public void feedAll() {
        tamagotchis.forEach(Tamagotchi::feed);
    }

    public void playAll() {
        tamagotchis.forEach(Tamagotchi::play);
    }

    public void removeTamagochi(Tamagotchi tamagotchi) {
        tamagotchis.remove(tamagotchi);
    }

    public void cleanAll() {
        tamagotchis.forEach(Tamagotchi::clean);
    }

    public void sleepAll() {
        tamagotchis.forEach(Tamagotchi::sleep);
    }
}