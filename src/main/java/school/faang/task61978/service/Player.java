package school.faang.task61978.service;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка воспроизводится.");
            } else {
                System.out.println("Музыка уже играет.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка на паузе.");
            } else {
                System.out.println("Музыка уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Пропускаем трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Возврат на предыдущий трек");
        }
    }
}