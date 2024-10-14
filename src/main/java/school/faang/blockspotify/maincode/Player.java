package school.faang.blockspotify.maincode;


public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Начать воспроизведение музыки");
                isPlaying = true;
            } else {
                System.out.println("Музыка уже воспроизведена");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Поставить музыку на паузу");
                isPlaying = false;
            } else {
                System.out.println("Музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("пропустить трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("вернуться к предыдущему треку");
        }
    }
}
