package school.faang.sprint_3.task_49712;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(5);

        List<Thread> players = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            players.add(new Thread(() -> {
                new Player().startBattle(boss);
            }));
        }

        players.forEach(Thread::start);
    }
}
