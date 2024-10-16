package school.faang.spotify;

public class Music {
    public static void main(String[] args) {
        Thread[] threads = new Thread[4];
        Player player = new Player();

        threads[0] = new Thread(player::play);
        threads[1] = new Thread(player::pause);
        threads[2] = new Thread(player::skip);
        threads[3] = new Thread(player::previous);

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
