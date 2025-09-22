package school.faang.bjs2_90320;

public class Music {
    private static final int THREAD_COUNTER = 4;

    public static void createAndStartThreads(Thread[] people, Player player) {
        people[0] = new Thread(player::play);
        people[1] = new Thread(player::pause);
        people[2] = new Thread(player::skip);
        people[3] = new Thread(player::previous);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] people = new Thread[THREAD_COUNTER];
        createAndStartThreads(people, new Player());

        for (Thread threads : people) {
            threads.start();
        }
        for (Thread threads : people) {
            threads.join();
        }
    }
}