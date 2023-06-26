package faang.school.godbless.thirdSprint.TheyWereVeryNice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        String[] chores = {"подметать пол", "мыть посуду", "стирать одежду"};

        for (String chore : chores) {
            service.execute(new Chore(chore));
        }
        service.shutdown();

        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Семья Уизли может спать спокойно, все дела сделаны.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
