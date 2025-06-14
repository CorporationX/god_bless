package school.faang.bjs2_80601;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
