package miniZoom_1379;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int COUNT_FOR_CONFERENCE = 10;

    public static void main(String[] args) {

        Conference conference = new Conference(COUNT_FOR_CONFERENCE);
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < COUNT_FOR_CONFERENCE; i++) {
            service.submit(() -> new Participant().joinConference(conference));
        }
        service.shutdown();
    }
}