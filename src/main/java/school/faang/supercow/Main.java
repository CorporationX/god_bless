package school.faang.supercow;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss(1);
        Player alex = new Player("Alex");
        Player bob = new Player("Bob");
        Thread alexBattle = new Thread(() -> alex.doBattle(boss));
        alexBattle.start();
        Thread bobBattle = new Thread(() -> bob.doBattle(boss));
        bobBattle.start();
    }
}