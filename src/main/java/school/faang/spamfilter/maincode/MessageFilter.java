package school.faang.spamfilter.maincode;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
