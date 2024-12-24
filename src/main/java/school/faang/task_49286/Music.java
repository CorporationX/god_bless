package school.faang.task_49286;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread user1 = new Thread(player::play, "Пользователь 1");
        user1.start();

        Thread user2 = new Thread(player::pause, "Пользователь 2");
        user2.start();

        Thread user3 = new Thread(player::skip, "Пользователь 3");
        user3.start();

        Thread user4 = new Thread(player::previous, "Пользователь 4");
        user4.start();
    }
}
