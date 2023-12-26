package faang.school.godbless.synchronization.spotify;

import java.util.ArrayList;
import java.util.List;

public class Music {

    public static void main(String[] args) {
        Player player = new Player();
        Player finalPlayer = player;
        Runnable playFunc = () -> finalPlayer.play();
        Runnable pauseFunc = () -> player.pause();
        Runnable skipFunc = () -> player.skip();
        Runnable previousFunc = () -> player.previous();

        List<Thread> threads = new ArrayList<>();

        threads.add(new Thread(playFunc, "playThread"));
        threads.add(new Thread(pauseFunc, "pauseThread"));
        threads.add(new Thread(skipFunc, "skipThread"));
        threads.add(new Thread(previousFunc, "previousThread"));
        for (Thread thread : threads) {
            thread.start();
        }
        boolean playing = player.isPlaying();
        System.out.println("playing = " + playing);
    }

}
