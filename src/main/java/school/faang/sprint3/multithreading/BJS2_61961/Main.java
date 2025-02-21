package school.faang.sprint3.multithreading.BJS2_61961;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threadList = List.of(
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::previous),
                new Thread(player::pause),
                new Thread(player::skip)
        );
        threadList.forEach(Thread::start);
    }
}
