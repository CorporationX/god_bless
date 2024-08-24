package faang.school.godbless.spotify;


public class Player {

    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("play - Песня уже играет");
            } else {
                isPlaying = true;
                System.out.println("play - Включили песню");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("pause - Музыка выключена");
            } else {
                isPlaying = false;
                System.out.println("pause - Поставили песню на паузу");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("skip - Музыка выключена");
            } else {
                System.out.println("skip - Скипнули песню");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("previous - Музыка выключена");
            } else {
                System.out.println("previous - Включили предыдущую песню");
            }
        }
    }
}
