package faang.school.godbless.sprint3.BJS2_6310;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"cook dinner", "clean the rooms", "wash clothes", "water the plants", "make the beds"};

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.execute(new Chore(chore));
        }

        executor.shutdown();
    }
}