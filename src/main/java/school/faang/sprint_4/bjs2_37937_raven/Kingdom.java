package school.faang.sprint_4.bjs2_37937_raven;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Slf4j
public class Kingdom {
    private final String name;

    public String sendMessage(Kingdom receiver) throws RavenLostException {
        if (Math.random() < 0.2) {
            throw new RavenLostException("Raven lost on the way from " + name + " to " + receiver.getName());
        }
        return "Raven successfully delivered message from " + name + " to " + receiver.getName();
    }
}
