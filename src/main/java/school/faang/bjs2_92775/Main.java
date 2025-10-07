package school.faang.bjs2_92775;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static school.faang.bjs2_92775.MasterCardService.OPERATION_EXECUTOR;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MasterCardService.executeOperation();

        OPERATION_EXECUTOR.shutdown();
        try {
            if (!OPERATION_EXECUTOR.awaitTermination(1, TimeUnit.MINUTES)) {
                OPERATION_EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            OPERATION_EXECUTOR.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
