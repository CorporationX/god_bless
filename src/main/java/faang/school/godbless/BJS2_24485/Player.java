package faang.school.godbless.BJS2_24485;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println(Thread.currentThread().getName() + ": Музыка начинает воспроизводиться.");
                isPlaying = true;
            } else {
                System.out.println(Thread.currentThread().getName() + ": Музыка уже играет.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println(Thread.currentThread().getName() + ": Музыка поставлена на паузу.");
                isPlaying = false;
            } else {
                System.out.println("Музыка уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + ": Пропуск текущего трека.");
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + ": Возвращение к предыдущему треку");
            isPlaying = true;
        }
    }
}
