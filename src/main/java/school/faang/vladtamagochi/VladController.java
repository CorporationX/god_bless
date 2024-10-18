package school.faang.vladtamagochi;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private List<TamagotchiVlad> vladiki = new ArrayList<>();

    public void addVlad(TamagotchiVlad vlad) {
        vladiki.add(vlad);
    }

    public void deleteVlad(TamagotchiVlad vlad) {
        vladiki.remove(vlad);
    }

    public void feedAll() {
        vladiki.forEach(TamagotchiVlad::feed);
    }

    public void playAll() {
        vladiki.forEach(TamagotchiVlad::play);
    }

    public void cleanAll() {
        vladiki.forEach(TamagotchiVlad::clean);
    }

    public void sleepAll() {
        vladiki.forEach(TamagotchiVlad::sleep);
    }

    public void printAllVladiki() {
        vladiki.forEach(System.out::println);
    }
}
