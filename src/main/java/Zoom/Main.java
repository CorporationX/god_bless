package Zoom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int numberOfParticipants = 5;
        Conference conference = new Conference(numberOfParticipants);

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfParticipants);

        for (int i = 0; i < numberOfParticipants; i++) {
            int number = i;
            executorService.submit(() -> new Participant("Name" + number).joinConference(conference));
        }

        executorService.shutdown();
    }
}
