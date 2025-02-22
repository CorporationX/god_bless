package school.faang.bjs2_60855;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        WeasleyFamily weasleyFamily = new WeasleyFamily();

        for (int i = 0; i < weasleyFamily.getChores().length; i++) {
            pool.submit(weasleyFamily.getChores()[i]);
        }
        pool.shutdown();
    }
}
