package faang.school.godbless.zoom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
@AllArgsConstructor
public class Participant {
    private int sleepMultiplier;
    private String name;

    @SneakyThrows
    public void joinConference(Conference conference) {
        Thread.sleep(300 * sleepMultiplier);
        conference.getBarrier().await();
        System.out.println(name + " joined the conference");
    }
}
