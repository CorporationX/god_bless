package school.faang.task_49171;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threadsList = new ArrayList<>(List.of(new Thread(() -> player.play()),
                new Thread(() -> player.pause()),
                new Thread(() -> player.skip()), new Thread(() -> player.previous())));

        for (Thread thread : threadsList) {
            thread.start();
        }
    }
}
