package faang.school.godbless.Spam_Filtering;

import java.util.ArrayList;
import java.util.List;

public class MessageProcessor {
    public void processMessage(String message, List<MessageFilter> messageFilter) {

    }

    public static void main(String[] args) {

        MessageFilter spamFilter = message -> message.contains("spam");
        MessageFilter badWordFilter = message -> message.contains("badword");
        MessageFilter linkFilter = message -> message.contains("https:");
        List<MessageFilter> messageFilterList = new ArrayList<>();
        messageFilterList.add(spamFilter);
        messageFilterList.add(badWordFilter);
        messageFilterList.add(linkFilter);
        MessageProcessor messageProcessor = new MessageProcessor();
        String message1 = "This is a spam message";
        String message2 = "This message contains badword";
        String message3 = "https://yandex/ru";
        messageProcessor.processMessage(message1,messageFilterList);
        messageProcessor.processMessage(message2,messageFilterList);
        messageProcessor.processMessage(message3,messageFilterList);
    }
}