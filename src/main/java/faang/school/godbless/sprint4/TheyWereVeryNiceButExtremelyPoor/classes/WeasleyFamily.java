package faang.school.godbless.sprint4.TheyWereVeryNiceButExtremelyPoor.classes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {
                "wash the dishes",
                "sweep the floor",
                "mow the lawn",
                "take out the trash",
                "cook dinner"
        };

        ExecutorService service = Executors.newFixedThreadPool(chores.length);

        for (String chore : chores){
            Chore c = new Chore(chore);
            service.submit(c);
        }

        service.shutdown();
    }

}
