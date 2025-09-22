package school.faang.multithreading.async.bjs2_92526;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
