package school.faang;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int playerId = i;
            threads.add(new Thread(() -> new Player("player" + playerId).startBattle(boss)));
        }
        threads.forEach(Thread::start);


    }

}