package faang.school.godbless;

public class Player {
    private Object lock = new Object();
    private String isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = "Музыка играет";
            System.out.println(isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = "Музыка стоит на пузе";
            System.out.println(isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = "Включили следующий трек";
            System.out.println(isPlaying);
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = "Включили предыдущий трек";
            System.out.println(isPlaying);
        }
    }
}
