package faang.school.godbless.TheBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task sheldonTask = new Task("Sheldon", "prepare theory");
        Task LeonardTask = new Task("Leonard", "model theory");
        Task HowardTask = new Task("Howard", "instrument development");
        Task RadjeshTask = new Task("Radjesh", "data analysis");
        executorService.submit(sheldonTask);
        executorService.submit(LeonardTask);
        executorService.submit(HowardTask);
        executorService.submit(RadjeshTask);
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(5, TimeUnit.HOURS)) {
                System.out.println("все кенты все на месте");
            }
            else {
                System.out.println("they definitely played dota 2 instead of this cool project");
            }
        } catch (InterruptedException e) {
            System.out.println("NOOOO THEY GOING TO PLAY DOTA 2");
        }

    }
}
