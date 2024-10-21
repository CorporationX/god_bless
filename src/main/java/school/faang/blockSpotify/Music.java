package school.faang.blockSpotify;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(player::play));
        threads.add(new Thread(player::play));
        threads.add(new Thread(player::pause));
        threads.add(new Thread(player::skip));
        threads.add(new Thread(player::previous));

        for (Thread thread : threads){
            thread.start();
        }
    }
}
