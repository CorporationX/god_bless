package school.faang.bjs2_80937;

import java.util.List;

public class Main {
    private static final MessageFilter SPAM_FILTER = message -> !message.toLowerCase().contains("спам");
    private static final MessageFilter GNIL_FILTER = message -> !message.toLowerCase().contains("гниль");
    private static final MessageFilter LENGTH_FILTER = message -> message.length() > 8;

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        List<MessageFilter> filters = List.of(SPAM_FILTER, LENGTH_FILTER, GNIL_FILTER);
        String[] messages = {"Привет!", "Проклятый старик", "гниль тупая", "Чивабчичи топ, кстати"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Прошло все фильтры: " + isFiltered);
        }
    }
}
