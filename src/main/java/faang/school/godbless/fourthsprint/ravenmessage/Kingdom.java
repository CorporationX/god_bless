package faang.school.godbless.fourthsprint.ravenmessage;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@Getter
public class Kingdom {
    private final String name;

    public String sendMessage(Kingdom target) {
        if (ThreadLocalRandom.current().nextBoolean()) {
            throw new RuntimeException("Raven failed to deliver message from " + name + " to " + target.getName());
        }
        return "Message successfully delivered from " + name + " to " + target.getName();
    }
}
