package bjs2_90211;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        // Запускаем все действия пользователей
        new Thread(() -> player.play(), "Пользователь 1").start();
        new Thread(() -> player.pause(), "Пользователь 2").start();
        new Thread(() -> player.skip(), "Пользователь 3").start();
        new Thread(() -> player.previous(), "Пользователь 4").start();
        new Thread(() -> player.play(), "Пользователь 5").start();
    }
}