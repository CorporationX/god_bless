package faang.school.godbless.Sprint_3.SpamFilter;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String str);
}
