package school.faang.m1.thread.spotify;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        Thread[] threads = new Thread[4];
        threads[0] = new Thread(player::play);
        threads[1] = new Thread(player::skip);
        threads[2] = new Thread(player::pause);
        threads[3] = new Thread(player::previous);
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
