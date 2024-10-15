package school.faang.telegram;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter messageFilter1 = (message -> !message.toLowerCase().contains("smap"));
        MessageFilter messageFilter2 = message -> message.length() > 5;
        MessageFilter messageFilter3 = message -> !message.contains("!");
        List<MessageFilter> messageFilters = Arrays.asList(messageFilter1, messageFilter2, messageFilter3);

        String msg1 = "!!!";
        String msg2 = "smap adsas";
        String msg3 = "snap";
        String msg4 = "Hello friends";
        boolean term1 = messageProcessor.processMessage(msg1, messageFilters);
        System.out.println(term1);
        System.out.println("-------------");

        boolean term2 = messageProcessor.processMessage(msg2, messageFilters);
        System.out.println(term2);
        System.out.println("-------------");

        boolean term3 = messageProcessor.processMessage(msg3, messageFilters);
        System.out.println(term3);
        System.out.println("-------------");

        boolean term4 = messageProcessor.processMessage(msg4, messageFilters);
        System.out.println(term4);
        System.out.println("-------------");
    }
}
