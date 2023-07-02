package faang.school.godbless.very_nice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] choresArray = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};
        List<Chore> chores = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < choresArray.length; i++) {
            chores.add(new Chore(choresArray[i]));
            executorService.submit(chores.get(i));
        }
        executorService.shutdown();
    }
}
