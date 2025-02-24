package school.faang.task_61881;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread firstUser = new Thread(player::play);
        Thread secondUser = new Thread(player::pause);
        Thread thirdUser = new Thread(player::skip);
        Thread fourthUser = new Thread(player::previous);

        List<Thread> threads = new ArrayList<>(List.of(firstUser, secondUser, thirdUser, fourthUser));

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("Ожидание завершения потока %s прервано", thread.getName());
                throw new RuntimeException(e);
            }
        }
    }
}
