package Concurrency_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Conference conference = new Conference(25);
        ExecutorService service = Executors.newFixedThreadPool(25);
        for (int i = 0; i < 25; i++) {
            int finalI = i;
            service.submit(() -> conference.addParticipant(new Participant("Participant" + (finalI + 1))));
        }
        service.shutdown();
    }
}
