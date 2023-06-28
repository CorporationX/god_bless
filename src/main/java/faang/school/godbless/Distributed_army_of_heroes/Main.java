package faang.school.godbless.Distributed_army_of_heroes;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        Army army = new Army();
        List<Runnable> tasks = new LinkedList<>();

        tasks.add(() -> army.addUnit(new Archer(25)));// считаем в потоке 1
        tasks.add(() -> army.addUnit(new Swordsman(40))); // считаем в потоке 2
        tasks.add(() -> army.addUnit(new Mage(50))); // считаем в потоке 3
        tasks.add(() -> army.addUnit(new Mage(20))); // считаем в потоке 4

        ExecutorService executors = Executors.newFixedThreadPool(4);

        for(Runnable task : tasks){
            executors.execute(task);
        }
        executors.shutdown();

        try {
            executors.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
