package school.faang.bjs2_80937;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter gnilFilter = message -> !message.toLowerCase().contains("гниль");
        MessageFilter lengthFilter = message -> message.length() > 8;

        MessageProcessor messageProcessor = new MessageProcessor();

        List<MessageFilter> filters = new ArrayList<>(List.of(spamFilter, lengthFilter, gnilFilter));
        String[] messages = {"Привет!", "Проклятый старик", "гниль тупая", "Чивабчичи топ, кстати"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Прошло все фильтры: " + isFiltered);
        }
    }
}
