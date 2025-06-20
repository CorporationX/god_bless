package school.faang.weasleyFamily81240;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static Chore[] chores = {
            new Chore("помыть посуду"),
            new Chore("подмести пол"),
            new Chore("приготовить ужин")};

    public static void main(String[] args) throws InterruptedException {
        System.out.println("начинаем работу");
        try (ExecutorService executor = Executors.newFixedThreadPool(chores.length)) {
            for (Chore chore : chores) {
                Thread.sleep(1000);
                executor.submit(chore);
            }
        }
        Thread.sleep(2000);
        System.out.println("все действия выполненны");
    }
}
