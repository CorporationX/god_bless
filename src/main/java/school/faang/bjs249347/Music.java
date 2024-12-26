package school.faang.bjs249347;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread user1 = new Thread(player::play, "Sergey");
        user1.start();

        Thread user2 = new Thread(player::pause, "Sasha");
        user2.start();

        Thread user3 = new Thread(player::skip, "Ruslan");
        user3.start();

        Thread user4 = new Thread(player::previous, "Elena");
        user4.start();
    }
}
