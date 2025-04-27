package school.faang.bjs270199;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}