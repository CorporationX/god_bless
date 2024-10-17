package school.faang.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread thread1 = new Thread(() -> {
            player.play();
            player.pause();
        });

        Thread thread2 = new Thread(() -> {
            player.skip();
            player.play();
        });

        Thread thread3 = new Thread(() -> {
            player.previous();
            player.pause();
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
