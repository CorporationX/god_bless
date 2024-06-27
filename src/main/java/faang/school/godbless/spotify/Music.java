package faang.school.godbless.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThead = new Thread(() -> player.play());
        playThead.start();

        Thread pauseThead = new Thread(() -> player.pause());
        pauseThead.start();

        Thread skipThread = new Thread(() -> player.skip());
        skipThread.start();

        Thread previousThread = new Thread(() -> player.previous());
        previousThread.start();
    }
}
