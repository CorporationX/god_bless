package spotify_blocking;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    protected void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("А музыка громече ту-ту-ту-ту(мелодия)");
                isPlaying = true;
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else{
                System.out.println("музыка уже играет");
            }
        }
    }

    protected void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("жесткий трек на паузе");
                isPlaying = true;
            }else {
                System.out.println("уже на паузе");
            }
        }
    }

    protected void skip() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("скипаем скучный трек");
                isPlaying = true;
            }else {
                System.out.println("ещё скипаем");
            }
        }
    }

    protected void previous() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("включить предыдущий трек");
                isPlaying = true;
            }else {
                System.out.println("скипаем ещё один трек назад");
            }
        }
    }
}
