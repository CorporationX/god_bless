package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task3;

import java.util.ArrayList;
import java.util.List;

public class Music {

    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        List<Thread> threads = new ArrayList<>();
        Thread thread1 = new Thread(player::play);
        Thread thread2 = new Thread(player::pause);
        Thread thread3 = new Thread(player::skip);
        Thread thread4 = new Thread(player::previous);
        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Done");
    }
}
