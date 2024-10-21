package school.faang.multithreading.asynchronism.send.raven;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Kingdom {
    private String name;

    public void sendMessage(Kingdom receiver) {
        if (Math.random() > 0.7) {
            log.error("Сообщение не доставлено из {} в {}", name, receiver.getName());
            throw new RuntimeException("Ворон не смог доставить сообщение");
        } else {
            log.info("Сообщение доставлено из {} в {}", name, receiver.getName());
        }
    }
}
