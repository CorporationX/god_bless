package something;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeaslyFamily {
    public static void main(String[] args) {
        String[] chores = new String[3];
        chores[0] = "Помыть пол";
        chores[1] = "Вытереть пыль";
        chores[2] = "Погулять с собакой";
        ExecutorService execute = Executors.newCachedThreadPool();

        for (int i = 0; i < chores.length; i++) {
            Chore chore = new Chore(chores[i]);
            execute.execute(chore);
        }

        try {
            if (!execute.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                System.out.println("Программа завершена");
                execute.shutdownNow();

            }
        } catch (InterruptedException e) {
            execute.shutdownNow();
        }
    }
}
