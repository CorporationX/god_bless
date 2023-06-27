package Sprint_4_Task8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Почистить зубу", "Подготовить к собеседованию", "Помыть посуду"};
        ExecutorService service = Executors.newCachedThreadPool();
        for (String chore : chores) {
            service.submit(new Chore(chore));
        }
        service.shutdown();
    }
}
