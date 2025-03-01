package school.faang.task_BJS2_61951;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(() -> player.play());
        playThread.start();
        Thread pausedThread = new Thread(() -> player.pause());
        pausedThread.start();
        Thread skipThread = new Thread(() -> player.skip());
        skipThread.start();
        Thread previousThread = new Thread(() -> player.previous());
        previousThread.start();
    }
}