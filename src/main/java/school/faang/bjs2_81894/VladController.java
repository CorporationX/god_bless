package school.faang.bjs2_81894;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class VladController {
    private final List<TamagotchiVlad> tamagotchiVlads = new ArrayList<>();

    public synchronized void addTamagotchiVlad(TamagotchiVlad t) {
        tamagotchiVlads.add(t);
        log.info("{} добавлен в список.", t.getName());
    }

    public synchronized void deleteTamagotchiVlad(TamagotchiVlad t) {
        tamagotchiVlads.remove(t);
        log.info("{} удален из списка.", t.getName());
    }

    public synchronized void feedAll() {
        tamagotchiVlads.forEach(TamagotchiVlad::feed);
    }

    public synchronized void playAll() {
        tamagotchiVlads.forEach(TamagotchiVlad::play);
    }

    public synchronized void cleanAll() {
        tamagotchiVlads.forEach(TamagotchiVlad::clean);
    }

    public synchronized void sleepAll() {
        tamagotchiVlads.forEach(TamagotchiVlad::sleep);
    }
}
