package faang.school.godbless.BJS2_24575;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Player {
    final Object lock = new Object();
    private String isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = "Воспроизведение музыки";
        }
        System.out.println(isPlaying);
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = "Пауза";
        }
        System.out.println(isPlaying);
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = "Песня пропущена";
        }
        System.out.println(isPlaying);
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = "Предыдущая песня";
        }
        System.out.println(isPlaying);
    }
}
