package faang.school.godbless.BJS2_25595;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Conference conference = new Conference("wow", 3);

        Participant participantOne = new Participant("Frank", conference);
        Participant participantTwo = new Participant("John", conference);
        Participant participantThree = new Participant("Bob", conference);

        Runnable joinToConferenceOne = participantOne::joinConference;
        Runnable joinToConferenceTwo = participantTwo::joinConference;
        Runnable joinToConferenceThree = participantThree::joinConference;
        Runnable startStream = conference::startStreaming;

        ExecutorService executor = Executors.newCachedThreadPool();
        Stream.of(joinToConferenceOne, joinToConferenceTwo, joinToConferenceThree, startStream)
                .forEach(executor::execute);
        executor.shutdown();
    }
}
