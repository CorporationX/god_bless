package school.faang.bjs281795;

public class User {
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        Player player = new Player();
        threads[1] = new Thread(() -> player.play());
        threads[2] = new Thread(() -> player.play());
        threads[3] = new Thread(() -> player.previous());
        threads[4] = new Thread(() -> player.skip());
        threads[0] = new Thread(() -> player.pause());
        for(Thread thread : threads) {
            thread.start();
        }
    }
}
