package faang.school.godbless;
//Создайте класс Player с методами для управления воспроизведением музыки: play(), pause(), skip() и previous().
//Добавьте поле lock в класс Player. Это будет объект-блокировка,
// который позволит синхронизировать доступ к изменению состояния воспроизведения на всех устройствах.
//Добавьте переменную isPlaying в класс Player, которая будет отслеживать текущее состояние воспроизведения музыки.

import java.util.concurrent.TimeUnit;

public class Player {
    private boolean isPlaying;
    private Object lock;
    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Playing");
        }
    }
    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Pausing");
        }
    }
    public void skip() {
        synchronized (lock) {
            isPlaying = false;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            isPlaying = true;
            System.out.println("Skipping");
        }
    }
    public void previous() {
        synchronized (lock) {
            isPlaying = false;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            isPlaying = true;
            System.out.println("Playing previous");
        }
    }
}
