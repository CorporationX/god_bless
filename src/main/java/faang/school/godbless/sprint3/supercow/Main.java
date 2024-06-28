package faang.school.godbless.sprint3.supercow;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Thread> listOfPlayerThreads = new ArrayList<>();
        Boss boss = new Boss(new ArrayList<>(), 5);

        for (int i = 0; i < 10; i++) {
            Player player = new Player("player" + i);
            listOfPlayerThreads.add(new Thread(() -> player.startBattle(boss)));
        }

        listOfPlayerThreads.forEach(Thread::start);
    }
}
