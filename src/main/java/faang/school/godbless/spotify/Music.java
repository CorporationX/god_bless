package faang.school.godbless.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nNow the same by static player\n");
        PlayerStatic playerStatic = new PlayerStatic();
        Thread playThreadStatic = new Thread(playerStatic::play);
        Thread pauseThreadStatic = new Thread(playerStatic::pause);
        Thread skipThreadStatic = new Thread(playerStatic::skip);
        Thread previousThreadStatic = new Thread(playerStatic::previous);

        playThreadStatic.start();
        pauseThreadStatic.start();
        skipThreadStatic.start();
        previousThreadStatic.start();

    }
}
