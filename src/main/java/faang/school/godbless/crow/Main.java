package faang.school.godbless.crow;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Kingdom kingdom1 = new Kingdom("kind39");
        Kingdom kingdom2 = new Kingdom("kind310");

        Kingdom.sendRaven(kingdom1, kingdom2);
    }
}
