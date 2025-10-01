package school.faang.s4_async_async_future;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
