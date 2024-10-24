package school.faang.java.thread1.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    private final Player player = new Player();
    private static final int numberCycles = 5;
    public static final int NUMBER_USERS = 4;
    private final ExecutorService executorService = Executors.newFixedThreadPool(Music.NUMBER_USERS);

    public static void main(String[] args) {
        Music m = new Music();
        for (int i = 0; i < Music.NUMBER_USERS; i++) {
            int athomicI = i;

            Runnable runnable = () -> {
                String nameUser = "User_" + athomicI;
                for (int j = 0; j < Music.numberCycles; j++) {
                    m.player.pause(nameUser);
                    m.player.play(nameUser);
                    m.player.previous(nameUser);
                    m.player.skip(nameUser);
                }
            };
            m.executorService.execute(runnable);
        }
        m.executorService.shutdown();
    }
}