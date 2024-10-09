package bjs2_33400;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();
        List<MessageFilter> filters = List.of(
                (msg) -> msg.startsWith("He"),
                (msg) -> msg.endsWith("lo"),
                (msg) -> msg.length() > 15
        );

        System.out.println(messageProcessor.processMessage("Hello", filters));
        System.out.println(messageProcessor.processMessage("He", filters));
        System.out.println(messageProcessor.processMessage("Some really long message", filters));
        System.out.println(messageProcessor.processMessage("lo", filters));
        System.out.println(messageProcessor.processMessage("Good msg", filters));
    }
}
