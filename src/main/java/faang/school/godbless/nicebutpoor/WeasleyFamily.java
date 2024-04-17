package faang.school.godbless.nicebutpoor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] choresAsStrings = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};
        List<Chore> chores = new ArrayList<>();
        ExecutorService service = Executors.newCachedThreadPool();


        for (String choresAsString : choresAsStrings) {
            chores.add(new Chore(choresAsString));
        }

        for (Chore chore : chores) {
            service.submit(chore);
        }

        service.shutdown();
    }
}
