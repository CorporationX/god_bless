package school.faang.asyncandfuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MasterCardServiceRunner {
    private static final int TREAD_COUNTER = 2;

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        ExecutorService executor = Executors.newFixedThreadPool(TREAD_COUNTER);
        service.doAll(executor);
    }
}
