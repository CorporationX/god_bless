package faang.school.godbless.kxnvg.zoom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Conference conference = new Conference("Boot camp conference");
        List<Participant> participants = getParticipant();

        ExecutorService service = Executors.newFixedThreadPool(10);

        for (Participant participant : participants) {
            service.execute(() -> {
                participant.joinConference();
                try {
                    conference.getBARRIER().await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        service.shutdown();
    }

    private static List<Participant> getParticipant() {
        List<Participant> participants = new ArrayList<>();

        String name = "user";
        for (int i = 0; i < 10; i++) {
            participants.add(new Participant(name + i));
        }
        return participants;
    }
}
