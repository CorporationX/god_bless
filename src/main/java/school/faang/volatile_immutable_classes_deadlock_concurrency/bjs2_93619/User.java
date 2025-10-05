package school.faang.volatile_immutable_classes_deadlock_concurrency.bjs2_93619;

import lombok.NonNull;

import java.util.concurrent.atomic.AtomicInteger;

public record User(int id, @NonNull String name) {

    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    public User {
        if (id == 0) {
            id = COUNTER.incrementAndGet();
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }
    }

    public User(@NonNull String name) {
        this(0, name);
    }
}