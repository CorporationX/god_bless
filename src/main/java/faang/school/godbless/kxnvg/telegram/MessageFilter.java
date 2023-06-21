package faang.school.godbless.kxnvg.telegram;

@FunctionalInterface
public interface MessageFilter {

    boolean filter(String message);
}
