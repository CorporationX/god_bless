package school.faang.spotify;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        Player player1 = new Player(true);
        Player player2 = new Player(false);
        Player player3 = new Player(true);
        Player player4 = new Player(true);

        Thread threadPlay = new Thread(player1::play);
        Thread threadPause = new Thread(player2::pause);
        Thread threadSkip = new Thread(player3::skip);
        Thread threadPrevious = new Thread(player4::previous);

        threads.add(threadPlay);
        threads.add(threadPause);
        threads.add(threadSkip);
        threads.add(threadPrevious);

        for (Thread thread : threads){
            thread.start();
        }

        for (Thread thread : threads){
            thread.join();
        }
    }
}
