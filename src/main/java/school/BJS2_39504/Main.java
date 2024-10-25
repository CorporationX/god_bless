package school.BJS2_39504;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        Conference conference = new Conference(10);

        for (int i = 1; i <= 10; i++) {
            int id = i;
            service.execute(() -> new Participant(id, conference).joinConference());
        }
        conference.startStreaming();
        service.shutdown();
    }

}