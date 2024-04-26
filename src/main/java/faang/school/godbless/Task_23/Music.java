package faang.school.godbless.Task_23;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        String lock = "lock";

        Thread playThread = new Thread(() -> new Player(lock, "Song is playing").play());
        Thread pauseThread = new Thread(() -> new Player(lock, "Music pause").pause());
        Thread skipThread = new Thread(() -> new Player(lock, "Song is skipped").skip());
        Thread previousThread = new Thread(() -> new Player(lock, "To previous song").previous());

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();

        playThread.join();
        pauseThread.join();
        previousThread.join();
        pauseThread.join();
    }
}
