package faang.school.godbless.multi.task3spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public synchronized void play() {
        if (!isPlaying) {
            System.out.println("* Играет музыка *");
            isPlaying = true;
        }
    };

    public synchronized void pause() {
        if (isPlaying) {
            System.out.println("* Тишина *");
            isPlaying = false;
        }
    };

    public synchronized void skip() {
        if (isPlaying) {
            System.out.println("* Играет следующая музыка *");
        }
    };

    public synchronized void previous() {
        if (isPlaying) {
            System.out.println("* Играет предыдущая музыка *");
        }
    };
}

