package blocking_spotify;

import java.util.List;

public class Music {
    /**
     * This is the main method of the application. It creates a Player object and four threads.
     * Each thread will call one of the methods of the Player class. The threads are then started.
     * The main thread will wait until all the threads have finished.
     *
     * @param args These are the command line arguments passed to the application.
     *             They are not used in this case.
     */
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> tasks = List.of(
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous)
        );

        tasks.forEach(Thread::start);
    }
}
