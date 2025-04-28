package school.faang.magicians;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolProvider {
    public static final ExecutorService executorService = Executors.newFixedThreadPool(3);
}
