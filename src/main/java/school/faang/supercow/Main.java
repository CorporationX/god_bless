package school.faang.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(4);
        Thread[] threads = new Thread[]{
                new Thread(() -> new Player("Jon").doBattle(boss)),
                new Thread(() -> new Player("Ron").doBattle(boss)),
                new Thread(() -> new Player("Bob").doBattle(boss)),
                new Thread(() -> new Player("Vlad").doBattle(boss)),
                new Thread(() -> new Player("Kain").doBattle(boss)),
                new Thread(() -> new Player("Noob").doBattle(boss))
        };
        for (Thread thread : threads) {
            thread.start();
        }
    }
}