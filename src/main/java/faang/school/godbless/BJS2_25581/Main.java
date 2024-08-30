package faang.school.godbless.BJS2_25581;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int NUMS_PARTICIPANTS = 10;
    private static final Conference conference = new Conference(NUMS_PARTICIPANTS);

    public static void main(String[] args) {
        List<Participant> participants = createParticipants(conference.getNUMS_PARTICIPANTS());
        ExecutorService executor = Executors.newCachedThreadPool();
        participants.forEach(participant -> executor.execute(participant::joinConference));
        try {
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static List<Participant> createParticipants(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Participant("Us_" + i, conference.getBarrier()))
                .toList();
    }
}
