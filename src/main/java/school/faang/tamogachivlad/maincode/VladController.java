package school.faang.tamogachivlad.maincode;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class VladController {
    private List<TamagotchiVlad> vlads = new ArrayList<>();
    public void addVlad(TamagotchiVlad vlad) {
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
