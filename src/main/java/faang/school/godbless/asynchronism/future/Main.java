package faang.school.godbless.asynchronism.future;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService.collectPayment();
        MasterCardService.collectPayment();
        System.out.println(MasterCardService.doAll());

    }
}
