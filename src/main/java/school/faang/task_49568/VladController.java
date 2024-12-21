package school.faang.task_49568;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class VladController {
    private final Set<TamagotchiVlad> vladList;

    public VladController() {
        this.vladList = new HashSet<>();
    }

    public void addVlad(@NonNull TamagotchiVlad vlad) {
        synchronized (vladList) {
            if (vladList.add(vlad)) {
                log.info("{} добавлен в список.", vlad);
            } else {
                log.warn("{} не удалось добавить в список.", vlad);
            }

        }
    }

    public void removeVlad(@NonNull TamagotchiVlad vlad) {
        synchronized (vladList) {
            if (vladList.remove(vlad)) {
                log.info("{} удалён из списка.", vlad);
            } else {
                log.warn("{} не удалось удалить из списка.", vlad);
            }
        }
    }

    public void feedAll() {
        synchronized (vladList) {
            vladList.forEach(TamagotchiVlad::feed);
        }
    }

    public void playAll() {
        synchronized (vladList) {
            vladList.forEach(TamagotchiVlad::play);
        }
    }

    public void cleanAll() {
        synchronized (vladList) {
            vladList.forEach(TamagotchiVlad::clean);
        }
    }

    public void sleepAll() {
        synchronized (vladList) {
            vladList.forEach(TamagotchiVlad::sleep);
        }
    }

}
