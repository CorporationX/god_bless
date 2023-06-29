package faang.school.godbless.Tournament.Kings.Landing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    public static void main(String[] args) {
        Knight knight1 = new Knight("Джорах Мармонт");
        Knight knight2 = new Knight("Бриана Тарт");

        knight1.addTrial(new Trial("Поединок на копьях"));
        knight1.addTrial(new Trial("Поединок на мечах"));

        knight2.addTrial(new Trial("Поединок на копьях"));
        knight2.addTrial(new Trial("Поединок на мечах"));

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> knight1.startTrials());
        executor.submit(() -> knight2.startTrials());

        executor.shutdown();
    }
}
