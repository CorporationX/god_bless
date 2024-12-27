package ru.maks1979.task_49374;

import lombok.Getter;
import lombok.Setter;

public class Player {
    @Getter
    private final Object lockObj = new Object();
    @Setter
    @Getter
    private boolean isPlaying;

    public void play() {
        synchronized (lockObj) {
            setPlaying(true);
            System.out.println("Проигрывается трек");
        }
    }

    public void pause() {
        synchronized (lockObj) {
            setPlaying(false);
            System.out.println("Пауза");
        }
    }

    public void skip() {
        synchronized (lockObj) {
            System.out.println("Следующий трек");
        }
    }

    public void previous() {
        synchronized (lockObj) {
            System.out.println("Возврат к предыдущему треку");
        }
    }

}
