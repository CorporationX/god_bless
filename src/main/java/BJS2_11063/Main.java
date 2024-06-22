package BJS2_11063;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army(List.of(
                new Archer(150),
                new Archer(250),
                new Swordsman(200),
                new Mage(300)));

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(army);
        executorService.shutdown();

        executorService.awaitTermination(1, TimeUnit.MINUTES);

        int totalPower = army.getTotalPower();
        System.out.println(totalPower);
    }
}