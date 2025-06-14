package school.faang.bjs2_80601;

import java.util.List;

public class MessageProcessor {
    public boolean filter(String message, List<MessageFilter> filters) {
        return filters.stream().allMatch(f -> f.filter(message));
    }

    public static void main(String[] args) {
        MessageProcessor processor = new MessageProcessor();

        MessageFilter noSpam = msg -> !msg.contains("spam");
        MessageFilter shortEnough = msg -> msg.length() < 50;

        List<MessageFilter> filters = List.of(noSpam, shortEnough);

        System.out.println(processor.filter("hello world", filters));
        System.out.println(processor.filter("this is spam message", filters));
    }
}