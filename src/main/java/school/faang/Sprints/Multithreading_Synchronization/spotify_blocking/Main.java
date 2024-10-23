package school.faang.Sprints.Multithreading_Synchronization.spotify_blocking;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = new ArrayList<>(List.of(
                new Thread(player::play),
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::skip),
                new Thread(player::play)
        ));
       threads.forEach(Thread::start);
    }
}