package school.faang.task_50701;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Kingdom {
    private String name;

    public void sendMessage(Kingdom receiver) {
        log.info("Message successfully sent from {} to {}", name,  receiver.getName());
    }
}
