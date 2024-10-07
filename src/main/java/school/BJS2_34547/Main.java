package school.BJS2_34547;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;

        List<MessageFilter> filters = Arrays.asList(spamFilter,lengthFilter);

        String[] messages = {"Привет!", "Это спам","Длинное сообщение без и эмодзи"};

        for (String x: messages) {
            boolean ifFiltered = messageProcessor.processMessage(x,filters);
            System.out.println("Сообщение: " + x + " | Пропущено: " + ifFiltered);
        }

    }

}
