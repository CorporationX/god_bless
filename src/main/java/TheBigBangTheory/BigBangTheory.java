package TheBigBangTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> listOfTasks = new ArrayList<>();

        listOfTasks.add(new Task("Preparing theory"));
        listOfTasks.add(new Task("Modeling experiment"));
        listOfTasks.add(new Task("Tool developing"));
        listOfTasks.add(new Task("Data analisys"));

        for (Task task : listOfTasks) {
            executorService.execute(task);
        }

        executorService.shutdown();
        while (true) {
            // без этой проверки сообщение об успешном выполнении выводилось ДО сообщений от потоков
            if (executorService.isTerminated()) {
                System.out.println("Все задачи выполнены");
                break;
            }
        }


    }
}
