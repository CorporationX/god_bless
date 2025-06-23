package school.faang.blocking_spotify;

public class Player {
    private final Object look = new Object();

    private Boolean isPlaying = false;

    public void play() {
        synchronized (look) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Включаем трек");
            } else {
                System.out.println("Трек уже играет");
            }
        }
    }

    public void pause() {
        synchronized (look) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Ставим трек на паузу");
            } else {
                System.out.println("Трек уже стоит на паузе");
            }
        }
    }

    public void skip() {
        synchronized (look) {
            System.out.println("Включен следующий трек");
        }
    }

    public void previous() {
        synchronized (look) {
            System.out.println("Включен предыдущий трек");
        }
    }
}
