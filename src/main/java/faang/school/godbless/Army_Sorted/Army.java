package faang.school.godbless.Army_Sorted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@AllArgsConstructor
@Getter
@Setter
public class Army {
    private List<Warrior> divisions;

    public void calculateTotalPower() throws  ExecutionException, InterruptedException {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(divisions.size());
            List<Future<Integer>> futures = new ArrayList<>();

            for (Warrior warrior : divisions) {
                Callable<Integer> task = () -> warrior.getPower();
                Future<Integer> future = executor.submit(task);
                futures.add(future);
            }
            int totalPower = 0;
            for (Future<Integer> future : futures) {
                totalPower += future.get();
            }
            System.out.println("Сила армии: " + totalPower);
            executor.shutdown();
            executor.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Warrior> warriors = new ArrayList<>();
        Mage mage = new Mage(20);
        Swordsman swordsman = new Swordsman(10);
        Archer archer = new Archer(5);
        warriors.add(mage);
        warriors.add(swordsman);
        warriors.add(archer);
        Army army = new Army(warriors);
        try {
            army.calculateTotalPower();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}