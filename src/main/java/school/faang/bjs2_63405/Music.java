package school.faang.bjs2_63405;

public class Music {
    private static final int AMOUNT_OF_THREADS = 4;

    public static void main(String[] args) {
        Player player = new Player();

        Thread[] threads = new Thread[AMOUNT_OF_THREADS];

        threads[0] = new Thread(player::play);
        threads[1] = new Thread(player::skip);
        threads[2] = new Thread(player::pause);
        threads[3] = new Thread(player::previous);

        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
            threads[i].start();
        }
    }
}
