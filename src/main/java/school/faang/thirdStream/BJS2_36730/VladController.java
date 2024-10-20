package school.faang.thirdStream.BJS2_36730;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VladController {
    private final List<TamagotchiVlad> vlads = new CopyOnWriteArrayList<>();

    public void addVlad(TamagotchiVlad vlad) {
        vlads.add(vlad);
        System.out.println(vlad.getName() + " добавлен в список.");
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
