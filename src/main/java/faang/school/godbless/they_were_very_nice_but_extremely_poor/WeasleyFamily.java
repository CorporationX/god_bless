package faang.school.godbless.they_were_very_nice_but_extremely_poor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> choresNames = List.of("помыть посуду", "приготовить обед", "подмести", "помыть пол", "накрыть на стол");

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String choreName : choresNames){
            executor.submit(new Chore(choreName));
        }
        executor.shutdown();
    }
}
