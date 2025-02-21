package school.faang;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    List<TamagotchiVlad> vlads = new ArrayList<>();

    public synchronized void addVlad(TamagotchiVlad vlad) {
        vlads.add(vlad);
    }

    public synchronized void removeVlad(TamagotchiVlad vlad) {
        vlads.remove(vlad);
    }

    public synchronized void feedAll() {
        for (TamagotchiVlad vlad : vlads) {
            vlad.play();
        }
    }

    public synchronized void playAll() {
        for (TamagotchiVlad vlad : vlads) {
            vlad.feed();
        }
    }

    public synchronized void cleanAll() {
        for (TamagotchiVlad vlad : vlads) {
            vlad.clean();
        }
    }

    public synchronized void sleepAll() {
        for (TamagotchiVlad vlad : vlads) {
            vlad.sleep();
        }
    }
}
