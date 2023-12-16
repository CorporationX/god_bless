package faang.school.godbless.multi.task3spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("* Играет музыка *");
                isPlaying = true;
            }
        }
    };

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("* Тишина *");
                isPlaying = false;
            }
        }
    };

    public void skip() {
        if (isPlaying) {
            System.out.println("* Играет следующая музыка *");
        }
    };

    public void previous() {
        if (isPlaying) {
            System.out.println("* Играет предыдущая музыка *");
        }
    };
}

