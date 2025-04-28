package school.faang.wow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPullSupplier {
    public static final ExecutorService executor = Executors.newFixedThreadPool(3);
}
