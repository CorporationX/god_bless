package faang.school.godbless.asyncAndFuture;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
