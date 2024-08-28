package faang.school.godbless;

import faang.school.godbless.Trial.Trial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Сэр Джейме");
        Knight knight2 = new Knight("Сэр Лорас");

        knight1.addTrial(new Trial(knight1.getName(), "Бой на мечах"));
        knight1.addTrial(new Trial(knight1.getName(), "Турнир на копьях"));

        knight2.addTrial(new Trial(knight2.getName(), "Стрельба из лука"));
        knight2.addTrial(new Trial(knight2.getName(), "Борьба"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        knight1.startTrials(executorService);
        knight2.startTrials(executorService);

        executorService.shutdown();
    }
}