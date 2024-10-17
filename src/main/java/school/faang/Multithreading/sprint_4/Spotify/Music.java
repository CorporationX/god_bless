package school.faang.Multithreading.sprint_4.Spotify;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = new ArrayList<>();

        threads.add(new Thread(player::play));
        threads.add(new Thread(player::pause));
        threads.add(new Thread(player::skip));
        threads.add(new Thread(player::previous));
        threads.add(new Thread(player::pause));
        threads.add(new Thread(player::play));

        for(Thread thread: threads){
            thread.start();
        }

    }
}
