package faang.school.godbless.BJS224523;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(() -> {
            player.play();
        }, "User1");

        Thread pauseThread = new Thread(() -> {
            player.pause();
        }, "User2");

        Thread skipThread = new Thread(() -> {
            player.skip();
        }, "User3");

        Thread previousThread = new Thread(() -> {
            player.previous();
        }, "User4");

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}

