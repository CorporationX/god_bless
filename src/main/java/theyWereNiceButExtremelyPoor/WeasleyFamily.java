package theyWereNiceButExtremelyPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        Chore[] chores = {new Chore("Clean the kitchen."), new Chore("Take out the trash."), new Chore("Vacuum the living room."), new Chore("Wash the dishes."), new Chore("Mow the lawn.")};
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executorService.submit(chore);
        }

        executorService.shutdown();
    }
}
