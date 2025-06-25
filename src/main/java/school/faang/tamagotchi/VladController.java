package school.faang.tamagotchi;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static school.faang.ConcurrentUtils.tryLockAndDo;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j(topic = "VladController")
public class VladController {

    private final Lock lock = new ReentrantLock();
    private final List<TamagotchiVlad> tamagotchis = new ArrayList<>();

    public void addTamagotchi(TamagotchiVlad t) {
        tryLockAndDo(lock, () -> {
            tamagotchis.add(t);
            log.info("Тамагочи добавлен");
        });
    }

    public void removeTamagotchi() {
        tryLockAndDo(lock, () -> {
            if (!tamagotchis.isEmpty()) {
                tamagotchis.remove(0);
                log.info("Тамагочи удалён");
            }
            log.info("Тамагочи больше нет!");

        });
    }

    public void feedAll() {
        tryLockAndDo(lock, () -> {
            for (var t : tamagotchis) {
                t.feed();
            }
        });
    }

    public void playAll() {
        tryLockAndDo(lock, () -> {
            for (var t : tamagotchis) {
                t.play();
            }
        });
    }

    public void cleanAll() {
        tryLockAndDo(lock, () -> {
            for (var t : tamagotchis) {
                t.clean();
            }
        });
    }

    public void sleepAll() {
        tryLockAndDo(lock, () -> {
            for (var t : tamagotchis) {
                t.sleep();
            }
        });
    }
}
