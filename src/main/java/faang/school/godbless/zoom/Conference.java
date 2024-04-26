package faang.school.godbless.zoom;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

@AllArgsConstructor
public class Conference {
    private String name;
    private final CyclicBarrier BARRIER;
    private List<Participant> participants = new ArrayList<>();

    public static void startStreaming(){
        System.out.println("The broadcast has started");
    }

    @SneakyThrows
    public void joinConference(@NonNull Participant participant){
        System.out.println("Participant " + participant.getName() + " try to join the conference");
        participants.add(participant);
        BARRIER.await();
        System.out.println("Participant " + participant.getName() + " successfully joined the conference");
    }

    public Conference(String name, int requiredNumberOfParticipants) {
        this.name = name;
        this.BARRIER = new CyclicBarrier(requiredNumberOfParticipants, Conference::startStreaming);
    }
}
