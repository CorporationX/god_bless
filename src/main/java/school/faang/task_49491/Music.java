package school.faang.task_49491;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        final List<Thread> doSomeThing = new ArrayList<>();
        doSomeThing.add(new Thread(player::play));
        doSomeThing.add(new Thread(player::pause));
        doSomeThing.add(new Thread(player::skip));
        doSomeThing.add(new Thread(player::previous));

        for (Thread thread : doSomeThing) {
            thread.start();
        }
    }
}
