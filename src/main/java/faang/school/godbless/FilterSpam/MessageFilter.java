package faang.school.godbless.FilterSpam;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String string);
}
