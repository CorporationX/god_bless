package school.faang.bro_force;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(10, 3);
        Thread thread = new Thread(() -> game.update());
        thread.start();
        Thread thread1 = new Thread(() -> game.update());
        thread1.start();
        Thread thread2 = new Thread(() -> game.update());
        thread2.start();
        Thread thread3 = new Thread(() -> game.update());
        thread3.start();
    }
}
