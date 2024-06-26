package faang.school.godbless.asynchrony_and_future;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
