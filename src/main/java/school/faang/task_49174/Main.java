package school.faang.task_49174;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        Runnable[] actions = {
                player::play,
                player::pause,
                player::play,
                player::skip,
                player::skip,
                player::previous
        };

        for (Runnable action : actions) {
            new Thread(action).start();
        }
    }
}
