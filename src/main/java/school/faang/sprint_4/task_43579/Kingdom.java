package school.faang.sprint_4.task_43579;

import lombok.SneakyThrows;

import java.util.Random;

public record Kingdom(String name) {
    private static final Random RANDOM = new Random();

    @SneakyThrows(MessageNotReceivedException.class)
    public String sendMessage(Kingdom receiver) {
        if (RANDOM.nextDouble() > 0.7) {
            throw new MessageNotReceivedException("Сообщение не было доставлено в " + receiver.name());
        }
        return "Сообщение успешно доставлено!";
    }
}