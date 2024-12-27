package ru.maks1979.task_49374;

import lombok.Getter;
import lombok.Setter;

public class Player {
    @Getter
    private final Object Lock = new Object();
    @Setter
    @Getter
    private boolean isPlaying;

    public void play() {
        synchronized (Lock) {
            setPlaying(true);
            System.out.println("Проигрывается трек");
        }
    }

    public void pause() {
        synchronized (Lock) {
            setPlaying(false);
            System.out.println("Пауза");
        }
    }

    public void skip() {
        synchronized (Lock) {
            System.out.println("Следующий трек");
        }
    }

    public void previous() {
        synchronized (Lock) {
            System.out.println("Возврат к предыдущему треку");
        }
    }

}
