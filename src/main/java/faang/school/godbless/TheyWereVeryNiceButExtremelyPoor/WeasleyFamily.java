package faang.school.godbless.TheyWereVeryNiceButExtremelyPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Почистить зубы","Выполнить задачу 1","Выполнить задачу 2",
                "Выполнить задачу 3","Выполнить задачу 4"};
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < chores.length; i++) {
            service.submit(new Chore(chores[i]));
        }
        service.shutdown();
    }
}
