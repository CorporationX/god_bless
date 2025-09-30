package school.faang.thread_pool;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * Проект: god_bless
 * Класс Chore
 * Автор: Vital
 */

@Slf4j
@RequiredArgsConstructor
class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        if (Objects.isNull(chore) || chore.isBlank()) {
            log.warn("Пустая задача, ничего выполнять не нужно.");
            return;
        }

        try {
            log.info("{} выполняет задачу: {}", Thread.currentThread().getName(), chore);
            Thread.sleep(1000); // имитация работы
            log.info("Задача '{}' выполнена!", chore);
        } catch (InterruptedException e) {
            log.error("Задача '{}' была прервана.", chore);
            Thread.currentThread().interrupt();
        }
    }
}