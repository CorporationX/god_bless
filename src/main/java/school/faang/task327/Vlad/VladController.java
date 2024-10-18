package school.faang.task327.Vlad;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    List<TamagotchiVlad> vlads = new ArrayList<>();

    public void feedAll() {
        synchronized (vlads) {
            vlads.stream().forEach(TamagotchiVlad::feed);
        }
    }

    public void playAll() {
        synchronized (vlads) {
            vlads.stream().forEach(TamagotchiVlad::play);
        }
    }

    public void cleanAll() {
        synchronized (vlads) {
            vlads.stream().forEach(TamagotchiVlad::clean);
        }
    }

    public void sleepAll() {
        synchronized (vlads) {
            vlads.stream().forEach(TamagotchiVlad::sleep);
        }
    }

    public void addVlad(TamagotchiVlad vlad) {
        synchronized (vlads) {
            vlads.add(vlad);
        }
    }

}
