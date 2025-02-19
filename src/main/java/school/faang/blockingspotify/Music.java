package school.faang.blockingspotify;

public class Music {
    private static final String[] USERS = {
            "Пользователь 1",
            "Пользователь 2",
            "Пользователь 3",
            "Пользователь 4"
    };

    public static void main(String[] args) {
        Player player = new Player();

        Runnable[] operations = {
                player::play,
                player::pause,
                player::skip,
                player::previous
        };

        for (int i = 0; i < operations.length; i++) {
            Thread thread = new Thread(operations[i], USERS[i]);
            thread.start();
        }
    }
}
