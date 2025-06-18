package school.faang.bjs2_81727_block_spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread[] threads = {
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::play),
                new Thread(player::skip),
                new Thread(player::previous),
                new Thread(player::skip),
        };

        for (Thread t : threads) {
            t.start();
        }
    }
}


