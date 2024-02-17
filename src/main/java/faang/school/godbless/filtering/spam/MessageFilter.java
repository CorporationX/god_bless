package faang.school.godbless.filtering.spam;
@FunctionalInterface
public interface MessageFilter {
    Boolean filter(String massage);
}
