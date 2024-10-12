package school.faangSprint2.t12;

@FunctionalInterface
interface MessageFilter {
    boolean filter(String message);
}