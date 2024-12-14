package faang.school.godbless.meta;

import lombok.Data;

import java.util.UUID;
import java.util.function.Consumer;

@Data
public class Handler {
    private String id;
    private Consumer<Notification> consumer;

    Handler(Consumer<Notification> consumer) {
        if (consumer == null) {
            throw new IllegalArgumentException("Consumer cannot be null");
        }
        this.id = UUID.randomUUID().toString();
        this.consumer = consumer;
    }
}
