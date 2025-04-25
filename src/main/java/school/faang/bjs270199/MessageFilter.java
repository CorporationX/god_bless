package school.faang.bjs270199;

@FunctionalInterface
public interface MessageFilter {
    Boolean filter(String getMessage);
}