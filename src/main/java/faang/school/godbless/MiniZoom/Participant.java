package faang.school.godbless.MiniZoom;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.BrokenBarrierException;

@AllArgsConstructor
@Getter
public class Participant {
    private String name;

    public void joinConference(Conference conference) {
        System.out.println(this.name + " подключился к конференции");
        try {
            conference.getBARRIER().await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
