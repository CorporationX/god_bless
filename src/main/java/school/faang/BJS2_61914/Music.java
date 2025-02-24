package school.faang.BJS2_61914;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread thread1 = new Thread(player::play);
        Thread thread2 = new Thread(player::pause);
        Thread thread3 = new Thread(player::skip);
        Thread thread4 = new Thread(player::previous);
        List<Thread> threads = List.of(thread1, thread2, thread3, thread4);
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
