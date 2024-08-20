package faang.school.godbless.meta;

import lombok.Data;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
public class Filter {
    private String id;
    private Predicate<Notification> predicate;
    private Consumer<Notification> consumer;
    private Function<Notification, String> messageTransformer;

    Filter(Predicate<Notification> predicate, Consumer<Notification> consumer, Function<Notification, String> messageTransformer) {
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate cannot be null");
        }
        if (consumer == null) {
            throw new IllegalArgumentException("Consumer cannot be null");
        }
        if (messageTransformer == null) {
            throw new IllegalArgumentException("MessageTransformer cannot be null");
        }
        this.id = UUID.randomUUID().toString();
        this.predicate = predicate;
        this.consumer = consumer;
        this.messageTransformer = messageTransformer;
    }
}
