package extremely_poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"wash dishes", "write code", "sleep", "eat", "walk", "do laundry"};

        ExecutorService service = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore task = new Chore(chore);
            service.execute(task);
        }

        service.shutdown();
    }
}
