package faang.school.godbless.multithreading_synchronization.supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player kirill = new Player("Кирилл");
        Player andrey = new Player("Андрей");
        Player pasha = new Player("Паша");
        Player yaroslav = new Player("Ярослав");
        Player victor = new Player("Виктор");

        Boss boss = new Boss();

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> kirill.startBattle(boss));
        executor.execute(() -> andrey.startBattle(boss));
        executor.execute(() -> pasha.startBattle(boss));
        executor.execute(() -> yaroslav.startBattle(boss));
        executor.execute(() -> victor.startBattle(boss));
    }
}
