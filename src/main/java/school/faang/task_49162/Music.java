package school.faang.task_49162;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        createAndStartThread(player::play);
        createAndStartThread(player::pause);
        createAndStartThread(player::previous);
        createAndStartThread(player::play);
        createAndStartThread(player::skip);
    }

    private static void createAndStartThread(Runnable runnable) {
        new Thread(runnable).start();
    }
}
