package faang.school.godbless.async.async_and_future;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        try {
            masterCardService.doAll();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
