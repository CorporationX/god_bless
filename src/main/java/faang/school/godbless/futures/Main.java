package faang.school.godbless.futures;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        try {
            MasterCardService.doAll();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
