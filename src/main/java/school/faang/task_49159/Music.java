package school.faang.task_49159;

public class Music {
    private static final Player PLAYER = new Player();

    private static final Thread PLAY_THREAD = new Thread(PLAYER::play);
    private static final Thread PAUSE_THREAD = new Thread(PLAYER::pause);
    private static final Thread SKIP_THREAD = new Thread(PLAYER::skip);
    private static final Thread PREVIOUS_THREAD = new Thread(PLAYER::previous);

    public static void main(String[] args) {
        PLAY_THREAD.start();
        PAUSE_THREAD.start();
        SKIP_THREAD.start();
        PREVIOUS_THREAD.start();
    }
}
