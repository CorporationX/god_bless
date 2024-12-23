package school.faang.task50610;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Slf4j
public record Kingdom(String name) {
    private static final String SUCCESS_MESSAGE = "Сообщение успешно доставлено";

    private void sendMessage(Kingdom receiver) {
        log.info("{} отправил сообщение {}", this, receiver);
    }

    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.runAsync(() -> {
            if (Math.random() < 0.4) {
                throw new IllegalArgumentException("sender не смог отправить сообщение");
            }
            sender.sendMessage(receiver);
        }).handle((result, ex) -> {
            if (Objects.nonNull(ex)) {
                log.error(ex.getMessage());
                return ex.getMessage();
            }

            log.info(SUCCESS_MESSAGE);

            return SUCCESS_MESSAGE;
        });
    }
}
