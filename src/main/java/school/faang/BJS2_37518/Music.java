package school.faang.BJS2_37518;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread user1 = new Thread(() -> player.play(), " User1 ");
        Thread user2 = new Thread(() -> player.pause(), " User2 ");
        Thread user3 = new Thread(() -> player.skip(), " User3 ");
        Thread user4 = new Thread(() -> player.previous(), " User4 ");

        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}
