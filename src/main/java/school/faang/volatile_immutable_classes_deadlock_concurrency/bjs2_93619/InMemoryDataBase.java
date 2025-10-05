package school.faang.volatile_immutable_classes_deadlock_concurrency.bjs2_93619;

import lombok.NonNull;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public final class InMemoryDataBase<K, U> {
    private final ConcurrentHashMap<K, U> table = new ConcurrentHashMap<>();

    public List<U> findByValueIf(@NonNull Predicate<U> predicate) {
        return table.values().stream()
                .filter(predicate)
                .toList();
    }

    public int size() {
        return table.size();
    }

    public List<K> getKeys() {
        return Collections.list(table.keys());
    }

    public U get(K id) {
        return table.get(id);
    }

    public boolean updateByValueIf(@NonNull K id, @NonNull UnaryOperator<U> valueHandler) {
        boolean isIdExists = table.containsKey(id);
        if (isIdExists) {
            table.compute(id, (k, oldValue) -> valueHandler.apply(oldValue));
        }
        return isIdExists;
    }

    public boolean removeByValueIf(@NonNull Predicate<U> predicate) {
        return table.values().removeIf(predicate);
    }

    public boolean removeById(@NonNull K id) {
        return table.remove(id) != null;
    }

    public Optional<U> findById(@NonNull K id) {
        return Optional.ofNullable(table.get(id));
    }

    public boolean putIfAbsent(@NonNull K id, @NonNull Supplier<U> valueSupplier) {

        AtomicBoolean hasElementAdded = new AtomicBoolean(false);
        table.computeIfAbsent(id, k -> {
            U v = Objects.requireNonNull(valueSupplier.get(),
                    "ConcurrentHashMap не принимает null");
            hasElementAdded.set(true);
            return v;
        });
        return hasElementAdded.get();
    }

    public boolean putIfAbsent(K id, U savedElement) {
        return putIfAbsent(id, () -> savedElement);
    }
}