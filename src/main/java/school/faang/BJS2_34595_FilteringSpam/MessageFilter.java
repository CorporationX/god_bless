package school.faang.BJS2_34595_FilteringSpam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
