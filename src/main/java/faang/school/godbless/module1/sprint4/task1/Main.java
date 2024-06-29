package faang.school.godbless.module1.sprint4.task1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        try {
            masterCardService.doAll();
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            log.error("Method doAll() broken", e);
            throw new RuntimeException(e);
        }

    }
}
