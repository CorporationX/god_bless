package ru.maks1979.task_49374;

import lombok.Getter;
import lombok.Setter;

public class Player {
    @Getter
    private final Object LockObj= new Object();
    @Setter
    @Getter
    private boolean isPlaying;

    public void play() {
        synchronized (LockObj) {
            setPlaying(true);
            System.out.println("Проигрывается трек");
        }
    }

    public void pause() {
        synchronized (LockObj) {
            setPlaying(false);
            System.out.println("Пауза");
        }
    }

    public void skip() {
        synchronized (LockObj) {
            System.out.println("Следующий трек");
        }
    }

    public void previous() {
        synchronized (LockObj) {
            System.out.println("Возврат к предыдущему треку");
        }
    }

}
