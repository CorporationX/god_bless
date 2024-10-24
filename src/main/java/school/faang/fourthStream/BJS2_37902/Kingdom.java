package school.faang.fourthStream.BJS2_37902;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Kingdom(String name) {
    private static final double FAILURE_CHANCE = 0.3;
    private static final int DELIVERY_TIME = 5_000;

    public void sendMessage(Kingdom receiver) throws Exception {
        log.info("Сообщение отправлено из {} в {}", name, receiver.name);
        sleep();
        if (Math.random() < FAILURE_CHANCE) {
            throw new Exception("Сообщение не доставлено из " + name + " в " + receiver.name);
        }
        log.info("Сообщение успешно доставлено из " + name + " в " + receiver.name());
    }

    private void sleep() {
        try {
            Thread.sleep(DELIVERY_TIME);
        } catch (InterruptedException e) {
            log.error("Упс.. В процессе доставки письма что-то пошло не так", e);
        }
    }
}
