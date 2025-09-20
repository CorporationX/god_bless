package school.faang.bjs2_90271;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        final Thread user1 = new Thread(() -> player.play(), "User1");
        final Thread user2 = new Thread(() -> player.pause(), "User2");
        final Thread user3 = new Thread(() -> player.skip(), "User3");
        final Thread user4 = new Thread(() -> player.previous(), "User4");
        final Thread user5 = new Thread(() -> player.play(), "User5");

        user1.start();
        user2.start();
        user3.start();
        user4.start();
        user5.start();

        try {
            user1.join();
            user2.join();
            user3.join();
            user4.join();
            user5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
