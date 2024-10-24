package school.faang.sprint3.blockingspotify;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        Thread playThread = new Thread(() -> player.play());
        Thread pauseThread = new Thread(() -> player.pause());
        Thread skipThread = new Thread(() -> player.skip());
        Thread previousThread = new Thread(() -> player.previous());

        startThreadWithDelay(playThread, 4000);
        startThreadWithDelay(pauseThread, 4000);
        startThreadWithDelay(skipThread, 4000);
        startThreadWithDelay(previousThread, 4000);
    }

    private static void startThreadWithDelay(Thread thread, long delay) {
        try {
            Thread.sleep(delay);
            thread.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
