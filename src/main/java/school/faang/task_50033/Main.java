package school.faang.task_50033;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
