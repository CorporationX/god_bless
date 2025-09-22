package school.faang.bjs289982;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        // Создаем пул потоков
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Создаем объект класса WeasleyFamily для получения списка задач
        WeasleyFamily weasleyFamily = new WeasleyFamily();

        // Добавляем задачи в пул потоков
        for (Chore chore : weasleyFamily.choreList) {
            executorService.submit(chore);
        }

        // Завершаем работу пула потоков после выполнения всех задач
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            System.out.println("Awating working threads");
        }
        System.out.println("All chores are done!");
    }
}
