package school.faang.bjs2_90472_Spotify;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> users = new ArrayList<>();
        List<Runnable> tasks = List.of(
                player::play,
                player::pause,
                player::skip,
                player::previous
        );

        for (Runnable task : tasks) {
            Thread user = new Thread(task);
            users.add(user);
            user.start();
        }

        try {
            for (Thread user : users) {
                user.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
