package faang.school.godbless.sprint_3.task_49409;

public class Music {

    private static final int NUMBER_OF_THREADS = 7;

    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        Thread[] threads = new Thread[NUMBER_OF_THREADS];

        threads[0] = new Thread(player::play);
        threads[1] = new Thread(player::previous);
        threads[2] = new Thread(player::skip);
        threads[3] = new Thread(player::pause);
        threads[4] = new Thread(player::skip);
        threads[5] = new Thread(player::play);
        threads[6] = new Thread(player::previous);

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
