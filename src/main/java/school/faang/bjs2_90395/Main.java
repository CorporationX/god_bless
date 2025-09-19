package school.faang.bjs2_90395;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Thread firstPlayerThread = new Thread(() -> new Player("Jake").doBattle(boss));
        firstPlayerThread.start();

        Thread secondPlayerThread = new Thread(() -> new Player("Lucy").doBattle(boss));
        secondPlayerThread.start();

        Thread thirdPlayerThread = new Thread(() -> new Player("Harry").doBattle(boss));
        thirdPlayerThread.start();

        Thread fourthPlayerThread = new Thread(() -> new Player("Matthew").doBattle(boss));
        fourthPlayerThread.start();

        Thread fifthPlayerThread = new Thread(() -> new Player("Larry").doBattle(boss));
        fifthPlayerThread.start();

        Thread sixthPlayerThread = new Thread(() -> new Player("Cyntia").doBattle(boss));
        sixthPlayerThread.start();
    }
}
