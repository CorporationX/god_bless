package school.faang.sprint3.bjs2_81770;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static final int THREAD_BATCH = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_BATCH);
        Player player = new Player();
        executor.execute(player::play);
        executor.execute(player::pause);
        executor.execute(player::previous);
        executor.execute(player::skip);
    }
}
