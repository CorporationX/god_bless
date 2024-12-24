package school.faang.sprint_4.task_asyncandfuturebjs2n49872;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

@Slf4j
public class AsyncAndFutureMain {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        try {
            service.doAll();
        } catch (ExecutionException | InterruptedException e) {
            log.info(e.getMessage());
        }
    }
}
