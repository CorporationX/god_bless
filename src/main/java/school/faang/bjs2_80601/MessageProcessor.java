package school.faang.bjs2_80601;

import java.util.List;

public class MessageProcessor {
    private static final MessageFilter NO_SPAM = msg -> !msg.contains("spam");
    private static final MessageFilter SHORT_ENOUGH = msg -> msg.length() < 50;

    public boolean passesAllFilters(String message, List<MessageFilter> filters) {
        return filters.stream().allMatch(f -> f.passesAllFilters(message));
    }

    public static void main(String[] args) {
        MessageProcessor processor = new MessageProcessor();
        List<MessageFilter> filters = List.of(NO_SPAM, SHORT_ENOUGH);

        System.out.println(processor.passesAllFilters("hello world", filters));
        System.out.println(processor.passesAllFilters("this is spam message", filters));
    }
}