package faang.school.godbless.Meta_universe;

@FunctionalInterface
interface NotificationFilter {
    boolean filter(String message);
}