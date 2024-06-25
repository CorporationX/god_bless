package faang.school.godbless.blockSpotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(() -> {
            player.play();
        }, "PlayThread");

        Thread pauseThread = new Thread(() -> {
            player.pause();
        }, "PauseThread");

        Thread skipThread = new Thread(() -> {
            player.skip();
        }, "SkipThread");

        Thread previousThread = new Thread(() -> {
            player.previous();
        }, "PreviousThread");

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();

        try {
            playThread.join();
            pauseThread.join();
            skipThread.join();
            previousThread.join();
        }  catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
