package school.faang.sprint_4.task_asyncandfuturebjs2n49872;

import java.util.concurrent.ExecutionException;

public class AsyncAndFutureMain {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        try {
            service.doAll();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
