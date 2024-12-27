package ru.maks1979.task_49374;

import lombok.Getter;
import lombok.Setter;

public class Player {
    @Getter
    private final Object LOCK = new Object();
    @Setter
    @Getter
    private boolean isPlaying;

    public void play() {
        synchronized (LOCK) {
            setPlaying(true);
            System.out.println("Проигрывается трек");
        }
    }

    public void pause() {
        synchronized (LOCK) {
            setPlaying(false);
            System.out.println("Пауза");
        }
    }

    public void skip() {
        synchronized (LOCK) {
            System.out.println("Следующий трек");
        }
    }

    public void previous() {
        synchronized (LOCK) {
            System.out.println("Возврат к предыдущему треку");
        }
    }

}
