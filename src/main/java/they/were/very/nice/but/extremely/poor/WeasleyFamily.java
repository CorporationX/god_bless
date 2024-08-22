package they.were.very.nice.but.extremely.poor;


import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        ExecutorService service =  Executors.newCachedThreadPool();
        String[] chores = {"Помыть посуду", "Постирать белье", "Погладить рубашки", "Вымыть полы", "Приготовить ужин"};

        Arrays.stream(chores).forEach(chore -> service.execute(new Chore(chore)));
        service.shutdown();
    }
}
