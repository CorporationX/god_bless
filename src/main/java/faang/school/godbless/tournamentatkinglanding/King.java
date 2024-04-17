package faang.school.godbless.tournamentatkinglanding;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    public static void main(String[] args) {
        List<Trial> list1 = List.of(
                new Trial("knight1", "trial1"),
                new Trial("knight1", "trial2"),
                new Trial("knight1", "trial3"),
                new Trial("knight1", "trial4"),
                new Trial("knight1", "trial5")
        );
        List<Trial> list2 = List.of(
                new Trial("knight2", "trial1"),
                new Trial("knight2", "trial2"),
                new Trial("knight2", "trial3"),
                new Trial("knight2", "trial4"),
                new Trial("knight2", "trial5")
        );

        Knight knight1 = new Knight("knight1", list1);
        Knight knight2 = new Knight("knight2", list2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(knight1::startTrial);
        executorService.submit(knight2::startTrial);
        executorService.shutdown();
    }

}
