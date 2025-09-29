package school.faang.spotify_blocking;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Проект: god_bless
 * Класс Player
 * Автор: Vital
 */

@Slf4j
@RequiredArgsConstructor
public class Player {

    @NonNull
    private final Object lock; //объект блокировки для синхронизации потоков

    @Getter
    private boolean isPlaying = false; //текущее состояние плеера

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Музыка воспроизводится.");
            } else {
                log.info("Музыка уже играет.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Музыка поставлена на паузу.");
            } else {
                log.info("Музыка уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Трек пропущен.");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Вернулись к предыдущему треку.");
        }
    }
}