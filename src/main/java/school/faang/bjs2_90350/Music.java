package school.faang.bjs2_90350;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread[] threads = new Thread[]{
                new Thread(player::play),
                new Thread(player::skip),
                new Thread(player::pause),
                new Thread(player::play),
                new Thread(player::play),
                new Thread(player::previous),
                new Thread(player::skip),
                new Thread(player::pause)
        };
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
