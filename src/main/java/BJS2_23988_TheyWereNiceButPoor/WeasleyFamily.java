package BJS2_23988_TheyWereNiceButPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final String[] CHORES = {"Wash all dishes", "Cut the plants", "Fix chair", "Buy products",
            "Buy books", "Send mails", "Take care of animals"};
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : CHORES) {
            executor.submit(new Chore(chore));
        }
        executor.shutdown();
    }
}
