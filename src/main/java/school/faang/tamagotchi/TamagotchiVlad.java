package school.faang.tamagotchi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static school.faang.ConcurrentUtils.tryLockAndDo;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j(topic = "TamagotchiVlad")
@RequiredArgsConstructor
public class TamagotchiVlad {

    private final String name;

    private final Lock lock = new ReentrantLock();
    private String state = "нейтральное";

    public void feed() {
        tryLockAndDo(lock, () -> {
            state = "сыт";
            log.info("{} ест. Состояние: {}", name, state);
        });
    }

    public void play() {
        tryLockAndDo(lock, () -> {
            state = "весел";
            log.info("{} играет. Состояние: {}", name, state);
        });
    }

    public void clean() {
        tryLockAndDo(lock, () -> {
            state = "чист";
            log.info("{} моется. Состояние: {}", name, state);
        });
    }

    public void sleep() {
        tryLockAndDo(lock, () -> {
            state = "бодр";
            log.info("{} спит. Состояние: {}", name, state);
        });
    }
}
