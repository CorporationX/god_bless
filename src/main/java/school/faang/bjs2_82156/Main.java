package school.faang.bjs2_82156;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Thread thread1 = new Thread(() -> new Player("David").doBattle(boss));
        thread1.start();
        Thread thread2 = new Thread(() -> new Player("Musk").doBattle(boss));
        thread2.start();
        Thread thread3 = new Thread(() -> new Player("Lopez").doBattle(boss));
        thread3.start();
        Thread thread4 = new Thread(() -> new Player("Jenifer").doBattle(boss));
        thread4.start();
        Thread thread5 = new Thread(() -> new Player("Andrey").doBattle(boss));
        thread5.start();
    }
}
