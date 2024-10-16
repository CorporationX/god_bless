package school.faang.multithreading.synchron.tamagotchi;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class VladController {
    private final List<TamagotchiVlad> tamagotchies = new ArrayList<>();

    public synchronized void add(TamagotchiVlad tamagotchi) {
        tamagotchies.add(tamagotchi);
        log.info("{} добавлен в список", tamagotchi);
    }

    public synchronized void remove(TamagotchiVlad tamagotchi) {
        tamagotchies.remove(tamagotchi);
        log.info("{} удален из списка", tamagotchi);
    }

    public synchronized void feedAll() {
        tamagotchies.forEach(TamagotchiVlad::feed);
    }

    public synchronized void playAll() {
        tamagotchies.forEach(TamagotchiVlad::play);
    }

    public synchronized void cleanAll() {
        tamagotchies.forEach(TamagotchiVlad::clean);
    }

    public synchronized void sleepAll() {
        tamagotchies.forEach(TamagotchiVlad::sleep);
    }
}
