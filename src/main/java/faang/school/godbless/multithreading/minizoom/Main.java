package faang.school.godbless.multithreading.minizoom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.*;

public class Main {
    public static void main(String[] args) {
        int quantity = 10;
        var countDownLatch = new CountDownLatch(quantity);
        var conference = Conference.builder()
                .quantity(quantity)
                .countDownLatch(countDownLatch)
                .build();
        List<Participant> participantList = new ArrayList<>();
        rangeClosed(1, quantity)
                .forEach(n -> participantList.add(new Participant("Participant" + n, countDownLatch)));


        var confCompFuture = conference.startStreaming();

        List<CompletableFuture<Void>> participantFutures = new ArrayList<>();
        participantList.forEach(participant -> participantFutures.add(participant.joinConference()));

        CompletableFuture<Void> allParticipantsJoined = CompletableFuture.allOf(
                participantFutures.toArray(new CompletableFuture[0]));

        allParticipantsJoined.thenCompose(aVoid -> confCompFuture)
                .join();

    }
}
