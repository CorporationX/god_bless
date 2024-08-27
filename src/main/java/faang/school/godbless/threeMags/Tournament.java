package faang.school.godbless.threeMags;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        var value = CompletableFuture.supplyAsync(() -> school.submitTask(task), service);
        service.shutdown();
        return value;
    }
}
