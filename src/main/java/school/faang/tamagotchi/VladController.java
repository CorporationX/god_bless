package school.faang.tamagotchi;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class VladController {

    private final List<TamagotchiVlad> vlads = new ArrayList<>();

    public synchronized void addVlad(TamagotchiVlad vlad) {
        if (vlad != null) {
            vlads.add(vlad);
            log.info("Модель {} добавлена!", vlad.getModel());
        }
    }

    public synchronized void remove(TamagotchiVlad vlad) {
        if (vlad != null) {
            vlads.remove(vlad);
        }
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
