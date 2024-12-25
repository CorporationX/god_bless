package school.faang.sprint4.task50970.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Kingdom {
    private static final int TIME_TO_LIVE_SEC = 2;
    private static final int TIME_TO_DIE_SEC = 1;

    private final String name;

    public String sendMessage(Kingdom receiver) throws Exception {
        if (Math.random() < 0.4) {
            Thread.sleep(TIME_TO_DIE_SEC * 1000);
            throw new Exception("Ошибка отправки сообщения в королевство " + receiver.getName());
        } else {
            Thread.sleep(TIME_TO_LIVE_SEC * 1000);
            return "Сообщение отправлено из " + name + " в " + receiver.getName();
        }
    }
}
