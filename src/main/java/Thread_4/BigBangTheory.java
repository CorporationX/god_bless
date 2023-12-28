package Thread_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Гор", "Закрыть все вкладки с маркетплейсами");
        Task task2 = new Task("Камиль", "Выполнить все задачи на стримы");
        Task task3 = new Task("Павел", "Провести retro");
        Task task4 = new Task("Кот под елкой", "Снести ёлку");
        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
        executor.submit(task4);
        executor.shutdown();
        System.out.println("All tasks complete");
    }
}
