package school.faang.universe.meta;

@FunctionalInterface
public interface Consumer<N> {
    void send(Notification notification);
}
