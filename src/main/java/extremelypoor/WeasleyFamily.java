package extremelypoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        Chore[] chores = new Chore[]
                {new Chore("помыть посуду"), new Chore("подмести пол"), new Chore("приготовить ужин")};

        ExecutorService executorService =  Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executorService.submit(chore);
        }

        executorService.shutdown();
    }
}
