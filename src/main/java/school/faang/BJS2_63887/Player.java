package school.faang.BJS2_63887;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("▶ Музыка запущена");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("⏸ Музыка на паузе");
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("⏭ Пропуск трека");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("⏮ Возвращение к предыдущему треку");
        }
    }
}
