package school.faang.asynchtony_and_future;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService cardService = new MasterCardService();
        cardService.doAll();
    }
}
