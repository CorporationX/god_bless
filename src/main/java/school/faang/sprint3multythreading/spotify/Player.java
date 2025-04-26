package school.faang.sprint3multythreading.spotify;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = true;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка начала воспроизводиться.");
            } else {
                System.out.println("Музыка уже играет.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Музыку остановили.");
                isPlaying = false;
            } else {
                System.out.println("Музыка уже остановлена.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Пропускаем трек.");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Вернулись к предыдущему треку");
        }
    }
}