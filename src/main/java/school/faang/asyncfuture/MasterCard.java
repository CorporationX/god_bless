package school.faang.asyncfuture;

import java.util.concurrent.ExecutionException;

public class MasterCard {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService.doAll();
    }
}
