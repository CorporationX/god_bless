package Sportify_BJS2_37318;

public class Music {
    public static void main(String[] args) {

        Player player = new Player();

        Thread user1 = new Thread(() -> player.play());
        Thread user2 = new Thread(() -> player.pause());
        Thread user3 = new Thread(() -> player.skip());
        Thread user4 = new Thread(() -> player.previous());

        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}