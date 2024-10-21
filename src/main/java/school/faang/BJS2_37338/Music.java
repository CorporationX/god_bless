package school.faang.BJS2_37338;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread user1 = new Thread(() -> {
            player.play();
            player.pause();
        }, "Пользователь 1");

        Thread user2 = new Thread(() -> {
            player.play();
            player.stop();
        }, "Пользователь 2");

        Thread user3 = new Thread(() -> {
            player.pause();
            player.skip();
        }, "Пользователь 3");

        user1.start();
        user2.start();
        user3.start();
    }
}
