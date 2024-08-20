package faang.school.godbless.uizliy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    private static final String[] CHORES = {"homework", "cleaning one room", "cooking", "cleaning another room"};

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("All threads released? : " + executorService.isShutdown());
        for (String chore : CHORES) {
            Chore nextChore = new Chore(chore);
            executorService.execute(nextChore);
        }
        executorService.shutdown();
        System.out.println("All threads released? : " + executorService.isShutdown());
    }
}
