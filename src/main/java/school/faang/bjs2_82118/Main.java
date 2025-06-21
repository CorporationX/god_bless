package school.faang.bjs2_82118;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player archer = new Player("Archer");
        Player knight = new Player("Knight");
        Player mage = new Player("Mage");

        Thread threadArcher = new Thread(() -> archer.doBattle(boss));
        Thread threadKnight = new Thread(() -> knight.doBattle(boss));
        Thread threadMage = new Thread(() -> mage.doBattle(boss));

        threadArcher.start();
        threadKnight.start();
        threadMage.start();
    }
}
