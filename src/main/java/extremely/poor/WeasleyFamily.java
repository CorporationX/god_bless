package extremely.poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Помыть посуду", "Подмести пол", "Протереть пыль", "Выкинуть мусор", "Приготовить ужин"};
        ExecutorService executors = Executors.newCachedThreadPool();
        try {
            for (String chore : chores) {
                executors.execute(new Chore(chore));
            }
            executors.shutdown();
        } catch (OutOfMemoryError e) {
            System.out.println("Недостаточно памяти" + e.getMessage());
        }
    }
}
