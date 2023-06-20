package faang.school.godbless.instagram_filters;

@FunctionalInterface
public interface Filters<T, N> {
    N getFilter(T image);
}
