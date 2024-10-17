package blockingSpotify_37172;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка воспроизводится.");
            } else {
                System.out.println("Музыка уже воспроизводится.");
            }
        }

    }

    public void stop() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка остановлена.");
            } else {
                System.out.println("Музыка уже остановлена.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Музыка пропущена.");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Вернулись к предыдущему треку");
        }
    }
}
