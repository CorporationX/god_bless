package faang.school.godbless.task.multithreading.tamagotchi.vlad;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class VladController {
    private final List<TamagotchiVlad> vlads = new ArrayList<>();

    public synchronized void addVlad(TamagotchiVlad vlad) {
        log.info("Add {}", vlad);
        vlads.add(vlad);
    }

    public synchronized void removeVlad(TamagotchiVlad vlad) {
        log.info("Remove {}", vlad);
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

    public void printAllVlads() {
        vlads.forEach(System.out::println);
    }
}
