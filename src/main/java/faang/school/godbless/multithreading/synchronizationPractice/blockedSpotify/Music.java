package faang.school.godbless.multithreading.synchronizationPractice.blockedSpotify;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        startPlayerWithMethods();
    }

    public static void startPlayerWithMethods() throws InterruptedException {
        Player player = new Player();

        List<Runnable> runnables = new ArrayList<>();

        Runnable playThread = (player::play);
        Runnable pauseThread = (player::pause);
        Runnable skipThread = (player::skip);
        Runnable previousThread = (player::previous);

        runnables.add(playThread);
        runnables.add(pauseThread);
        runnables.add(skipThread);
        runnables.add(previousThread);

        for (Runnable runnable : runnables) {
            new Thread(runnable).start();
            Thread.sleep(new Random().nextInt(1_000, 5_000));
        }

        System.out.println("Last value isPlaying is - " + player.isPlaying());
    }
}
