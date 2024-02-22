package faang.school.godbless.filterspam;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static List<MessageFilter> filtermessage =new ArrayList<>();

    public static void Filtermessage(){
        MessageProcessor messageProcessor =new MessageProcessor();
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> !(message.length() > 10);
        MessageFilter emojiFilter = message -> !message.contains("😀");

        filtermessage.add(spamFilter);
        filtermessage.add(lengthFilter);
        filtermessage.add(emojiFilter);

        String[] messages = {"Hello!", "Это spam!", "How are you? 😀", "Long message without spam and emoji"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filtermessage);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
