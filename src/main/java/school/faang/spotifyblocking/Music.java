package school.faang.spotifyblocking;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread userMusicThread1 = new Thread(() -> {
            player.play();
            player.skip();
        });

        Thread userMusicThread2 = new Thread(player::pause);

        Thread userMusicThread3 = new Thread(() -> {
            player.play();
            player.pause();
        });

        userMusicThread1.start();
        userMusicThread2.start();
        userMusicThread3.start();
    }
}
