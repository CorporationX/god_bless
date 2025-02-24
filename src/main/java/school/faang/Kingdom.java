package school.faang;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Getter
public class Kingdom {
    private final String name;
    private static final double PROBABILITY_OF_ERROR = 0.4;

    public String sendMassage(Kingdom otherKingdom) {
        if (Math.random() < PROBABILITY_OF_ERROR) {
            throw new RuntimeException("Raven could not deliver message from " +
                    name + " to " + otherKingdom.name);
        }
        return String.format("Message from %s to %s successfully delivered.", name, otherKingdom.name);
    }
}
