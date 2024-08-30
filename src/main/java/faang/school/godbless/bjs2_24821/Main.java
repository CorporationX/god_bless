package faang.school.godbless.bjs2_24821;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
