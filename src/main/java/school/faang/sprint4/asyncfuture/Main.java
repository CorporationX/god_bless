package school.faang.sprint4.asyncfuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main (String[] arg) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
