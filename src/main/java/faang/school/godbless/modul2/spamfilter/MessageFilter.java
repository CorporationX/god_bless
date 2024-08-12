package faang.school.godbless.modul2.spamfilter;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
