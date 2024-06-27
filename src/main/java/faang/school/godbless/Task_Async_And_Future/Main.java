package faang.school.godbless.Task_Async_And_Future;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService test = new MasterCardService();
        test.doAll();
    }
}
