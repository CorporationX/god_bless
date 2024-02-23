package spotify_blocking;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    protected void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("А музыка громече ту-ту-ту-ту(мелодия)");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                isPlaying = false;
            }else{
                System.out.println("музыка уже играет");
            }
        }
    }
    protected void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("жесткий трек на паузе");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                isPlaying = false;
            }else {
                System.out.println("уже на паузе");
            }
        }
    }

    protected void skip() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("скипаем скучный трек");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                isPlaying = false;
            }else {
                System.out.println("ещё скипаем");
            }
        }
    }

    protected void previous() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("включить предыдущий трек");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                isPlaying = false;
            }else {
                System.out.println("скипаем ещё один трек назад");
            }
        }
    }
}
