package faang.school.godbless.send_crow;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Kingdom {
    private String name;

    public void sendMessage(Kingdom anotherKingdom) {
        log.info(name + " sent message to " + anotherKingdom.name);
    }
}
