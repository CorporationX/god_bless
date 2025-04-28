package BJS2_73479;

import java.util.List;

public class Main {
    private static final int MAX_PLAYERS = 3;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);

        Player swordsman = new Player("Swordsman");
        Player archer = new Player("Archer");
        Player magician = new Player("Magician");
        Player warlock = new Player("Warlock");

        List<Thread> threads = List.of(new Thread(() -> swordsman.doBattle(boss)),
                new Thread(() -> archer.doBattle(boss)),
                new Thread(() -> magician.doBattle(boss)),
                new Thread(() -> warlock.doBattle(boss)));

        threads.forEach(Thread::start);
    }
}
