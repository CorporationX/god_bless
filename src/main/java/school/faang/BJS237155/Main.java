package school.faang.BJS237155;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    final static int THREAD_POOL = 4;

    public static void main(String[] args) {
        Player player = new Player(false);
        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL);
        service.submit(player::play);
        service.submit(player::pause);
        service.submit(player::skip);
        service.submit(player::previous);

        service.shutdown();

        try {
            if (!service.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Не все задачи завершились в отведенное время");
                service.shutdownNow();
            } else {
                System.out.println("Все задачи завершены");
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            e.printStackTrace();
        }

    }
}
