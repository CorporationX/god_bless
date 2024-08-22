package faang.school.godbless.nicePoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"убраться", "умыться", "провести переговоры о поставках вновую зеландию"};

        ExecutorService service = Executors.newCachedThreadPool();

        for (String s : chores) {
            Chore chore = new Chore(s);
            service.execute(chore);
        }

        service.shutdown();
    }
}
