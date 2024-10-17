package school.faang.spotify;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(false);

        List<Thread> playerTreads = new ArrayList<>(List.of(
                new Thread(player::play),
                new Thread(player::previous),
                new Thread(player::play),
                new Thread(player::skip),
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::pause)
        ));

        playerTreads.forEach(Thread::start);

        playerTreads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new IllegalStateException("Thread has been interrupted " + e.getMessage());
            }
        });
    }
}
