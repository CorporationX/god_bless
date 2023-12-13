package faang.school.godbless.filterSpam;
@FunctionalInterface
public interface MessageFilter {
    boolean filter(String str);
}
