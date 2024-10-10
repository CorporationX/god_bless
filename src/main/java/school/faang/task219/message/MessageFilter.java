package school.faang.task219.message;
@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
