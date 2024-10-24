package school.faang.sprint3.blockingspotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка восперезводитсяя");
            } else {
                System.out.println("Музыка играеть");
            }
        }
    }

    public void pause() {
        synchronized (lock){
            if (isPlaying){
                isPlaying = false;
                System.out.println("Музыка поставлина на паузу");
            }else {
                System.out.println("Музыка уже на паузе");
            }
        }
        isPlaying = false;

    }

    public void skip() {
        synchronized (lock){
            System.out.println("Трек пропущен");
        }

    }

    public void previous() {
        synchronized (lock){
            System.out.println("Вернулись к предыдущем треку.");
        }

    }
}
