package school.faang.bjs2_92628;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll(executor);
    }
}
