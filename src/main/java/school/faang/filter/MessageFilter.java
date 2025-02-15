package school.faang.filter;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}

