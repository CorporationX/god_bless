package zoom;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.BrokenBarrierException;

@Data
@AllArgsConstructor
public class Participant {
    private static final int MAX_PARTICIPANT = 4;
    private String name;

    public void joinConference(Conference conference) {
        try {
            System.out.println(this.getName() + " connect to group");
            conference.getBarrier().await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
