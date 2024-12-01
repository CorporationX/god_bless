package school.faang.BJS237542;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка играет: Туц туц туц туц ->" + " Cостояние: " + isPlaying);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка стоит на паузе :( ->" + " Cостояние: " + isPlaying);
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Пропустить трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Предыдущий трек");
        }
    }
}
