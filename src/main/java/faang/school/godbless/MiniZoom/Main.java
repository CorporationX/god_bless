package faang.school.godbless.MiniZoom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Conference conference = new Conference(5);
        Participant participant = new Participant("Harry");
        Participant participant2 = new Participant("Ron");
        Participant participant3 = new Participant("Hermione");
        Participant participant4 = new Participant("Draco");
        Participant participant5 = new Participant("Sirius");

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.execute(() -> participant.joinConference(conference));
        executor.execute(() -> participant2.joinConference(conference));
        executor.execute(() -> participant3.joinConference(conference));
        executor.execute(() -> participant4.joinConference(conference));

        Thread.sleep(2000);

        executor.execute(() -> participant5.joinConference(conference));

        executor.shutdown();
    }
}
