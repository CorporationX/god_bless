package school.faang.tamagotchi;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class VladController {
    private final CopyOnWriteArrayList<TamagotchiVlad> vlads = new CopyOnWriteArrayList<>();

    public void addVlad(TamagotchiVlad vlad) {
        vlads.add(vlad);
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

    public List<TamagotchiVlad> getVlads() {
        return List.copyOf(vlads);
    }
}
