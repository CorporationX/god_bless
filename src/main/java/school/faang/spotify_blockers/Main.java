package school.faang.spotify_blockers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = new ArrayList<>();

        while (true) {
            threads.add(new Thread(player::play));
            threads.add(new Thread(player::stop));
            threads.add(new Thread(player::skip));
            threads.add(new Thread(player::previous));
            break;
        }
        threads.forEach(Thread::start);
    }
}

