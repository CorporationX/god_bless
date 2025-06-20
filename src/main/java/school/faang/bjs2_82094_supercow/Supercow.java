package school.faang.bjs2_82094_supercow;

public class Supercow {
    public static void main(String[] args) {
        Boss cowBoss = new Boss(5);

        new Thread(() -> new Player("Bob").doBattle(cowBoss)).start();
        new Thread(() -> new Player("Alice").doBattle(cowBoss)).start();
        new Thread(() -> new Player("Carl").doBattle(cowBoss)).start();
        new Thread(() -> new Player("Gustav").doBattle(cowBoss)).start();
        new Thread(() -> new Player("Mobi").doBattle(cowBoss)).start();
        new Thread(() -> new Player("Dick").doBattle(cowBoss)).start();
        new Thread(() -> new Player("Clairmont").doBattle(cowBoss)).start();
    }
}
