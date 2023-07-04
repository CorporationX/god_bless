package faang.school.godbless.sprint5.asyncAndFuture;

import faang.school.godbless.sprint5.asyncAndFuture.classes.MasterCardService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        try {
            service.doAll();
        } catch (ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
