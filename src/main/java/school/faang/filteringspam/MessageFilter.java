package school.faang.filteringspam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
