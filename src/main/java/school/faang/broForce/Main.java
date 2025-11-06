package school.faang.broForce;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(0, 6);
        Thread thread1 = new Thread(() -> game.update(true, true));
        Thread thread2 = new Thread(() -> game.update(false, false));
        Thread thread3 = new Thread(() -> game.update(true, true));
        Thread thread4 = new Thread(() -> game.update(false, true));
        Thread thread5 = new Thread(() -> game.update(true, true));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }
}
