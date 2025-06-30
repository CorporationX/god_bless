package school.faang.bjs2_82178;

public class Main {
    private static final int MAX_PLAYERS = 2;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);

        Player wizard = new Player("Wizard");
        Player archer = new Player("Archer");
        Player knight = new Player("Knight");

        Thread wizardThread = new Thread(() -> wizard.doBattle(boss));
        Thread archerThread = new Thread(() -> archer.doBattle(boss));
        Thread knightTread = new Thread(() -> knight.doBattle(boss));

        wizardThread.start();
        archerThread.start();
        knightTread.start();
    }
}
