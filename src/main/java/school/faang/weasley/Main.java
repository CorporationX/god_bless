package school.faang.weasley;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        WeasleyFamily weasleyFamily = new WeasleyFamily();
        weasleyFamily.addChroe(new Chore("помыть посуду"));
        weasleyFamily.addChroe(new Chore("подмести пол"));
        weasleyFamily.addChroe(new Chore("приготовить ужин"));

        for (Chore chore : weasleyFamily.chroes) {
            executorService.execute(chore);
        }

        executorService.shutdown();
    }
}
