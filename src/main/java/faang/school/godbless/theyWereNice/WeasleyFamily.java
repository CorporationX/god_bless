package faang.school.godbless.theyWereNice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = new String[10];
        for (int i = 0; i < chores.length; i++) {
            chores[i] = "Задача №'" + i + "'";
        }
        ExecutorService service = Executors.newFixedThreadPool(4);

        for (var chore : chores){
            service.submit(new Chore(chore));
        }
        service.shutdown();
    }
}
