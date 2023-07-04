package Telegram;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String s);
}
