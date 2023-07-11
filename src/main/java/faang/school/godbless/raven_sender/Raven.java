package faang.school.godbless.raven_sender;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Raven {

    private Kingdom destination;
    private String message;

    public void flyingToDestination() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
