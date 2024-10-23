package ru.kraiush.BJS2_37163;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Thread thread1 = new Thread(() -> {
            game.update(true, false);
            game.update(false, false);
            game.update(true, true);
        });
        Thread thread2 = new Thread(() -> {
            game.update(true, true);
            game.update(false, true);
        });
        Thread thread3 = new Thread(() -> {
            game.update(true, true);
            game.update(false, true);
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
