package sprint4.harrypotter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"помыть пол","поспать","погладить кота","выпить темненького"};
        ExecutorService service = Executors.newCachedThreadPool();
        for (String chore : chores) {
            service.execute(new Chore(chore));
        }
        service.shutdown();
    }
}
