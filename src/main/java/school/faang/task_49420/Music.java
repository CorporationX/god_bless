package school.faang.task_49420;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        final Thread playThread = new Thread(() -> player.play());
        playThread.start();
        final Thread pauseThread = new Thread(() -> player.pause());
        pauseThread.start();
        final Thread skipThread = new Thread(() -> player.skip());
        skipThread.start();
        final Thread previousThread = new Thread(() -> player.previous());
        previousThread.start();

        try {
            playThread.join();
            pauseThread.join();
            skipThread.join();
            previousThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All threads completed.");
    }
}