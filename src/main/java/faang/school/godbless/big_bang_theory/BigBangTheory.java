package faang.school.godbless.big_bang_theory;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Task proveBBTheory = new Task("Sheldon", "Proving the Big Bang theory");
        Task modelBB = new Task("Leonard", "Modeling the Big Bang");
        Task evolvePussyAttractor = new Task("Howard", "Creating pussies attractor");
        Task analyseHowardRizz = new Task("Rajesh", "Analyze Howard's chances");

        List<Task> tasks = List.of(proveBBTheory, modelBB, evolvePussyAttractor, analyseHowardRizz);

        for (var task : tasks) {
            executor.submit(task);
        }

        executor.awaitTermination(15, TimeUnit.SECONDS);
        System.out.println("\nNow it's time for Halo!");
        executor.shutdown();
    }
}
