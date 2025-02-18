package school.faang.BJS2_61698;

public class Music {
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        Thread playThread = new Thread(() -> player.play());
        Thread pauseThread = new Thread(() -> player.pause());
        Thread skipThread = new Thread(() -> player.skip());
        Thread previousThread = new Thread(() -> player.previous());

        playThread.start();
        Thread.sleep(1000);
        pauseThread.start();
        Thread.sleep(1000);
        skipThread.start();
        Thread.sleep(1000);
        previousThread.start();
    }
}