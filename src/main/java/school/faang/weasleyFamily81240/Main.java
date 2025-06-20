package school.faang.weasleyFamily81240;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("начинаем работу");
        ExecutorService executor = Executors.newFixedThreadPool(WeasleyFamily.getChores().length);
        try {
            for (Chore chore : WeasleyFamily.getChores()) {
                Thread.sleep(1000);
                executor.submit(chore);
            }
        } finally {
            executor.shutdown();
        }
        Thread.sleep(2000);
        System.out.println("все действия выполненны");
    }
}
