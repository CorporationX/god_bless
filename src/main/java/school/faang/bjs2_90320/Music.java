package school.faang.bjs2_90320;

import java.util.Arrays;

public class Music {
    private static final int THREAD_COUNTER = 4;

    private static void initializeThreads(Thread[] people, Player player) {
        people[0] = new Thread(player::play);
        people[1] = new Thread(player::pause);
        people[2] = new Thread(player::skip);
        people[3] = new Thread(player::previous);
    }

    private static void startThreads(Thread[] people) {
        Arrays.stream(people).forEach(Thread::start);
    }

    private static void joinThreads(Thread[] people) {
        Arrays.stream(people).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void main(String[] args) {
        Thread[] people = new Thread[THREAD_COUNTER];
        initializeThreads(people, new Player());
        startThreads(people);
        joinThreads(people);
    }
}