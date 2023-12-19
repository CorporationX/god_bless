package faang.school.godbless.extremely_poor;

import lombok.AllArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        String[] chores = {"cleaning", "washing", "cooking", "dishwashing", "shopping", "dog walking"};

        for (int i = 0; i < chores.length; i++) {
            Chore chore = new Chore(chores[i]);
            executor.execute(chore);
        }
        executor.shutdown();
    }
}

@AllArgsConstructor
class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()); //для себя сделал sout. чтобы увидеть наглядно
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}