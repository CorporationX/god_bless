package school.faang.kingstournament;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        List<Trial> trialsOne = List.of(new Trial("Maksimus", "Water and Fire"),
                new Trial("Maksimus", "work with streams"));
        List<Trial> trialTwo = List.of(new Trial("Alex", "work with stream API"),
                new Trial("Alex", "kill the bear"));
        Knight myKnight = new Knight("Maksimus", trialsOne);
        Knight yourKnight = new Knight("Alex", trialTwo);
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(myKnight::startTrials);
        service.submit(yourKnight::startTrials);
        service.shutdown();
    }
}
