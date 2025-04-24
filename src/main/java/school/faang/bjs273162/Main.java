package school.faang.bjs273162;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        new Thread(() -> player.play(), "user1").start();
        new Thread(() -> player.pause(), "user2").start();
        new Thread(() -> player.skip(), "user3").start();
        new Thread(() -> player.previous(), "user4").start();
    }
}

