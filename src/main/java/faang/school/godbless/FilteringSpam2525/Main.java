package faang.school.godbless.FilteringSpam2525;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();
        MessageFilter filter1 = message -> message.contains("BadWord");
        MessageFilter filter2 = message -> message.isEmpty();
        MessageFilter filter3 = message -> message.equalsIgnoreCase("Filter me");
        List<MessageFilter> filterList = new ArrayList<>(List.of(filter1, filter2, filter3));

        String[] messages = {"BadWord you!", "Good message 1", "Should be filtered BadWord", "", "filter me", "Good message 2",
                "Should be BadWordfiltered"};

        for (String message : messages) {
            if (messageProcessor.processMessage(message, filterList)) {
                System.out.println(message);
            }
        }
    }
}