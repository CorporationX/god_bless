package faang.school.godbless.BJS2_12508;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = new String[]{"почистить ковер", "постирать вещи", "помыть посуду", "вытереть пыль"};

        ExecutorService service = Executors.newCachedThreadPool();

        for (String chore : chores) {
            service.execute(new Chore(chore));
        }

        service.shutdown();
    }
}