package school.faang.task_49557;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    List<TamagotchiVlad> vlads = new ArrayList<>();

    public void addVlad() {
        TamagotchiVlad vlad = new TamagotchiVlad();
        vlads.add(vlad);
    }

    public void removeVlad(TamagotchiVlad vlad) {
        vlads.remove(vlad);
    }

    public void feedAll() {
        vlads.forEach(TamagotchiVlad::feed);
    }

    public void playAll() {
        vlads.forEach(TamagotchiVlad::play);
    }

    public void cleanAll() {
        vlads.forEach(TamagotchiVlad::clean);
    }

    public void sleepAll() {
        vlads.forEach(TamagotchiVlad::sleep);
    }
}
