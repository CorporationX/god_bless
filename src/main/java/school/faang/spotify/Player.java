package school.faang.spotify;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка воспроизводится");
            } else {
                System.out.println("Музыка не играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Ставим на паузу");
            } else {
                System.out.println("Уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Пропускаем");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Включаем предыдущий трек");
        }
    }
}
