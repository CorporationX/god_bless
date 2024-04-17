package faang.school.godbless.InterfacesLambda.FilteringSpam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
