package faang.school.godbless.BJS2_1580;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Data
public class Participant {
    private static final AtomicInteger count = new AtomicInteger(1);
    private final Conference conference;
    private final int id = count.getAndIncrement();
    private String name;

    public void joinConference() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Participant #" + id + "joined");
        conference.getLatch().countDown();
    }
}