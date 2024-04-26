package faang.school.godbless.bjs2_5957;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class Kingdom {
    private String name;

    public void sendMessage(Kingdom kingdom) {
        log.info("Sending message to {}", kingdom.getName());
    }
}
