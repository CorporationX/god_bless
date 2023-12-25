package faang.school.godbless.TheyWereVeryNice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String [] chores = {"помыть посуду","убрать со стола","полить огород","связать свитер","накормить Коросту","сварить борщ","наловить рыбы"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < chores.length; i++) {
            executorService.execute(new Chore(chores[i]));
        }
        executorService.shutdown();

    }
}
