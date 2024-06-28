package faang.school.godbless.mini_zoom;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Conference.NUMBER_OF_PARTICIPANTS);

        getParticipants().forEach(participant -> executorService.execute(participant::joinConference));

        executorService.shutdown();
    }

    private static List<Participant> getParticipants() {
        return List.of(
                new Participant("First"),
                new Participant("Second"),
                new Participant("Third"),
                new Participant("Fourth"),
                new Participant("Fifth"),
                new Participant("Sixth"),
                new Participant("Seventh"),
                new Participant("Eighth"),
                new Participant("Ninth"),
                new Participant("Tenth")
        );
    }

}
