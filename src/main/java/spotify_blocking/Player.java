package spotify_blocking;

import lombok.SneakyThrows;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("А музыка громече ту-ту-ту-ту(мелодия)");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("музыка уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("жесткий трек на паузе");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("уже на паузе");
            }
        }
    }

    @SneakyThrows
    public void skip() {
        synchronized (lock) {
            System.out.println("скипаем скучный трек");
            Thread.sleep(1000L);
        }
    }

    @SneakyThrows
    public void previous() {
        synchronized (lock) {
            System.out.println("включить предыдущий трек");
            Thread.sleep(1000L);
        }
    }
}
