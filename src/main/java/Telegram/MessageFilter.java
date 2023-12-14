package Telegram;

@FunctionalInterface
public interface MessageFilter {
    Boolean filter(String message);
}
