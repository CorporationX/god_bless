package school.faang.async.async_and_future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }

}
