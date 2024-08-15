package faang.school.godbless;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() <= 40;
        MessageFilter alertFilter = message -> !message.contains("alert");

        List<MessageFilter> filters = List.of(
                spamFilter,
                lengthFilter,
                alertFilter
        );
        List<String> messagesThatNeedToBeFiltered = List.of(
                "Hello!",
                "This is just a message",
                "This is a spam message!",
                "This is a long message without spam and emojis",
                "There is an alert in this message!",
                "There is an a_l_e_r_t in this message!"
        );

        for (String message : messagesThatNeedToBeFiltered) {
            messageProcessor.processMessage(message, filters);
        }
    }
}