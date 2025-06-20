package school.faang.weasleyFamily81240;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("начинаем работу");
        try (ExecutorService executor = Executors.newFixedThreadPool(WeasleyFamily.getChores().length)) {
            for (Chore chore : WeasleyFamily.getChores()) {
                Thread.sleep(1000);
                executor.submit(chore);
            }
        }
        Thread.sleep(2000);
        System.out.println("все действия выполненны");
    }
}
