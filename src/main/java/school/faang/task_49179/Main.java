package school.faang.task_49179;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> users = new ArrayList<>();
        users.add(new Thread(() -> player.play()));
        users.add(new Thread(() -> player.pause()));
        users.add(new Thread(() -> player.skip()));
        users.add(new Thread(() -> player.play()));
        users.add(new Thread(() -> player.previous()));
        users.add(new Thread(() -> player.pause()));

        users.forEach(Thread::start);
    }
}
