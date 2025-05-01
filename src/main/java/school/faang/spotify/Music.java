package school.faang.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread user1 = new Thread(() -> player.play());
        user1.start();

        Thread user2 = new Thread(() -> player.pause());
        user2.start();

        Thread user3 = new Thread(() -> player.skip());
        user3.start();

        Thread user4 = new Thread(() -> player.previous());
        user4.start();
    }
}
