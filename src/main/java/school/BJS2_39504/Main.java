package school.BJS2_39504;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int COUNT_OF_MIN_REQUIRED_PARTICIPANTS = 10;

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        Conference conference = new Conference(COUNT_OF_MIN_REQUIRED_PARTICIPANTS);

        for (int i = 1; i <= COUNT_OF_MIN_REQUIRED_PARTICIPANTS; i++) {
            int id = i;
            service.execute(() -> new Participant(id, conference).joinConference());
        }
        conference.startStreaming();
        service.shutdown();
    }

}
