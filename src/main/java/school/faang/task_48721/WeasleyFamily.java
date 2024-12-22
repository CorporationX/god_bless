package school.faang.task_48721;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Сварить пельмени", "Подмести пол", "Починить диван",
                "Выгулять собаку", "Вынести мусор", "Убраться в комнате"};

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String task : chores){
            Chore chore = new Chore(task);
            executor.execute(chore);
        }

        executor.shutdown();
    }
}
