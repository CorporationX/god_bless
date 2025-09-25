package school.faang.bjs2_92538;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final ExecutorService exec = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        MasterCardService.doAll(exec);
    }
}