package school.faang.bjs2_81801;

public class Music {
    private static final int USER_COUNT = 100;
    private static final int METHOD_COUNT = 4;

    public static void main(String[] args) {
        Thread[] threads = new Thread[USER_COUNT];
        Player player = new Player();
        for (int i = 0; i < USER_COUNT; i++) {
            Runnable runnable = switch (i % METHOD_COUNT) {
                case 0 -> player::play;
                case 1 -> player::pause;
                case 2 -> player::skip;
                case 3 -> player::previous;
                default -> throw new IllegalStateException(" Unexpected value: " + i);
            };
            Thread thread = new Thread(runnable);
            threads[i] = thread;
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
