package school.faang.bjs2_82125;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player john = new Player("John");
        Player mary = new Player("Mary");
        Player kevin = new Player("Kevin");
        Player nicholas = new Player("Nicholas");
        Player elizabeth = new Player("Liz");

        Thread johnThread = new Thread(() -> john.doBattle(boss));
        Thread maryThread = new Thread(() -> mary.doBattle(boss));
        Thread kevinThread = new Thread(() -> kevin.doBattle(boss));
        final Thread nicholasThread = new Thread(() -> nicholas.doBattle(boss));
        final Thread elizabethThread = new Thread(() -> elizabeth.doBattle(boss));

        johnThread.start();
        maryThread.start();
        kevinThread.start();
        nicholasThread.start();
        elizabethThread.start();
    }
}
