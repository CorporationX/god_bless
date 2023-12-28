package faang.school.godbless.multi.task4vlad;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private final List<TamagotchiVlad> vlads = new ArrayList<>();

    public synchronized List<TamagotchiVlad> getVlads() {
        return vlads;
    }

    public synchronized void addVlad(TamagotchiVlad vlad) {
        vlads.add(vlad);
    }

    public synchronized void removeVlad(TamagotchiVlad vlad) {
        vlads.remove(vlad);
    }

    public synchronized void feedAll() {
        vlads.forEach(TamagotchiVlad::feed);
    }

    public synchronized void playAll() {
        vlads.forEach(TamagotchiVlad::play);
    }

    public synchronized void cleanAll() {
        vlads.forEach(TamagotchiVlad::clean);
    }

    public synchronized void sleepAll() {
        vlads.forEach(TamagotchiVlad::sleep);
    }
}
