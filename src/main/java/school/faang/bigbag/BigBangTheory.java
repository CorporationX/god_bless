package school.faang.bigbag;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Future futureOne = service.submit(new Task("Programming", "create method"));
        Future futureTwo = service.submit(new Task("Sheff", "Cooking"));
        Future futureThree = service.submit(new Task("Stoke", "iron the clothes"));
        Future futureFour = service.submit(new Task("Smock", "blow smoke"));

        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);
        if (futureOne.isDone()) {
            System.out.println("Задача один выполнена!");
        }
        if (futureTwo.isDone()) {
            System.out.println("Задача два выполнена!");
        }
        if (futureThree.isDone()) {
            System.out.println("Задача три выполнена!");
        }
        if (futureFour.isDone()) {
            System.out.println("Задача четыре выполнена!");
        }
    }
}
