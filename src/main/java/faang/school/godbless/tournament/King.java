package faang.school.godbless.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight = new Knight("Tirion");
        Knight knight1 = new Knight("Jamie");

        knight.addTrials(new Trial(knight.getName(), "поединок на мечах"));
        knight.addTrials(new Trial(knight.getName(), "верховая езда"));
        knight.addTrials(new Trial(knight.getName(), "опустошение пивной бочки"));
        knight1.addTrials(new Trial(knight1.getName(), "турник рыцарей"));
        knight1.addTrials(new Trial(knight1.getName(), "битва с драконом"));
        knight1.addTrials(new Trial(knight1.getName(), "поединок на мечах"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        knight.startTrials(executorService);
        knight1.startTrials(executorService);
        executorService.shutdown();
    }
}


