package school.faang.filterspam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String string);
}
