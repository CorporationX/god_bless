package faang.school.godbless.kxnvg.extremelypoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};
        ExecutorService service = Executors.newCachedThreadPool();

        for (String chore : chores) {
            service.execute(new Chore(chore));
        }
        service.shutdown();
    }
}
