package school.faang.thirdStream.BJS2_36730;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VladController {
    private final List<TamagotchiVlad> vlads = new CopyOnWriteArrayList<>();

    public synchronized void addVlad(TamagotchiVlad vlad) {
        vlads.add(vlad);
        System.out.println(vlad.getName() + " добавлен в список.");
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
