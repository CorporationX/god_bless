package faang.school.godbless.nice_but_poot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {
        String[] chores = {"cleaning", "shopping", "doing laundry", "cooking"};
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < chores.length; i++){
            Chore chore = new Chore(chores[i]);
            executorService.execute(chore);
        }

        executorService.shutdown();
    }
}


