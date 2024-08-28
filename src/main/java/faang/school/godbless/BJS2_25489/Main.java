package faang.school.godbless.BJS2_25489;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int PARTICIPANTS_PER_CONFERENCE = 15;
    private static ExecutorService executors = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        Conference eggOrChicken = new Conference("What was earlier - egg or chicken?", PARTICIPANTS_PER_CONFERENCE);

        for (int i = 1; i <= PARTICIPANTS_PER_CONFERENCE; i++) {
            int finalI = i;
            executors.execute(() -> new Participant("Participant " + finalI).joinConference(eggOrChicken));
        }
        eggOrChicken.startStreaming();
        executors.shutdown();
    }
}
