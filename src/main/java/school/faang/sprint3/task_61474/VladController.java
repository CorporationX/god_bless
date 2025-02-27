package school.faang.sprint3.task_61474;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class VladController {
    private final List<TamagotchiVlad> vladList = new ArrayList<>();

    public synchronized void addVlad(TamagotchiVlad vlad) {
        vladList.add(vlad);
        log.info("{} добавлен в список.", vlad);
    }

    public synchronized void removeVlad(TamagotchiVlad vlad) {
        vladList.remove(vlad);
        log.info("{} удалён из списка.", vlad);
    }

    public synchronized void feedAll() {
        for (TamagotchiVlad vlad : vladList) {
            vlad.feed();
        }
    }

    public synchronized void playAll() {
        for (TamagotchiVlad vlad : vladList) {
            vlad.play();
        }
    }

    public synchronized void cleanAll() {
        for (TamagotchiVlad vlad : vladList) {
            vlad.clean();
        }
    }

    public synchronized void sleepAll() {
        for (TamagotchiVlad vlad : vladList) {
            vlad.sleep();
        }
    }
}
