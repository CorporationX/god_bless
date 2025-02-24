package school.faang.BJS2_63887;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@EqualsAndHashCode
@Getter
public class Player {
    private final Lock lock = new ReentrantLock();
    private boolean isPlaying;

    public void play() {
        isPlaying = true;
        System.out.println("▶ Музыка запущена");
    }

    public void pause() {
        isPlaying = false;
        System.out.println("⏸ Музыка на паузе");
    }

    public void skip() {
        isPlaying = true;
        System.out.println("⏭ Пропуск трека");
    }

    public void previous() {
        isPlaying = true;
        System.out.println("⏮ Возвращение к предыдущему треку");
    }
}
