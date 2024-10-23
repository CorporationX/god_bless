package school.faang.asynchandfuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        MasterCardService cardService = new MasterCardService();
        cardService.doAll(executor);
    }
}
