package school.faang.sprint3.task_49239;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = List.of(
                new Thread(player::play),
                new Thread(player::previous),
                new Thread(player::pause),
                new Thread(player::skip)
        );
        threads.forEach(Thread::start);
    }
}
