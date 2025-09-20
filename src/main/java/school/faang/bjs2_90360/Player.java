package school.faang.bjs2_90360;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private boolean isPlaying;

    public synchronized void play() {
        if (isPlaying) {
            System.out.println("плейлист уже проигрывается.");
        }
        isPlaying = true;
        log.info("{} включает музыку.", Thread.currentThread().getName());
    }

    public synchronized void pause() {
        if (!isPlaying) {
            System.out.println("плейлист уже на паузе.");
        }
        isPlaying = false;
        log.info("{} ставит плейлист на паузу.", Thread.currentThread().getName());
    }

    public synchronized void skip() {
        log.info("{} скипает текущий трэк - играет следующий.", Thread.currentThread().getName());
    }

    public synchronized void previous() {
        log.info("{} включает предыдущий трэк.", Thread.currentThread().getName());
    }
}
