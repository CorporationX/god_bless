package school.faang.Multithreading.sprint_4.Crows;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
@AllArgsConstructor
public class Kingdom {
    public final static long TIME_SEND_MESSAGE = 2_000;

    private String name;

    public String sendMessage(Kingdom receiver) {
        try {
            Thread.sleep(TIME_SEND_MESSAGE);
        } catch (InterruptedException e) {
            log.error("Операция была прервана");
            throw new RuntimeException(e);
        }

        if (Math.random() < 0.3) {
            throw new RuntimeException("Ворон не смог доставить сообщение из " + name + " в " + receiver.getName());
        }

        return name + " отправило сообщение получателю в " + receiver.getName();
    }
}