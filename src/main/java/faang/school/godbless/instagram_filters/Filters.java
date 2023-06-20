package faang.school.godbless.instagram_filters;

public interface Filters<T, N> {
    N getFilter(T image);
}
