package school.faang.weasley;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        WeasleyFamily weasleyFamily = new WeasleyFamily();
        weasleyFamily.addChroe(new Chore("помыть посуду"));
        weasleyFamily.addChroe(new Chore("подмести пол"));
        weasleyFamily.addChroe(new Chore("приготовить ужин"));

        for (Chore chore : weasleyFamily.getChroes()) {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
            executorService.execute(chore);
        }
        executorService.shutdown();
    }
}
