package school.faang.blockingspotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread user1 = new Thread(player::play, "Пользователь 1");
        Thread user2 = new Thread(player::pause, "Пользователь 2");
        Thread user3 = new Thread(player::skip, "Пользователь 3");
        Thread user4 = new Thread(player::previous, "Пользователь 4");
        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}
