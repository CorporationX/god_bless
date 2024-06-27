package faang.school.godbless.domain.task_Future;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }

}
