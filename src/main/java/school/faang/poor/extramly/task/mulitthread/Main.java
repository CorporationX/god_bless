package school.faang.poor.extramly.task.mulitthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};
        ExecutorService executorService = Executors.newCachedThreadPool();

        System.out.println("Начало выполнения домашних задач:");

        for (String chore : chores) {
            Chore task = new Chore(chore);
            executorService.submit(task);
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }

        System.out.println("Все задачи выполнены.");
    }
}
