package faang.school.godbless.Sprint_3.Lambda.SpamFilter;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String str);
}
