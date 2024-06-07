package faang.school.godbless.functionalInterfaces.spam;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        // Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter lohotronFilter = message -> !message.contains("you've won!");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, lohotronFilter);

        // Обработка сообщений
        String[] messages = {"Hi!", "This is spam! But you can win 100500 money with us!", "Congratulations, you've won!", "Somebody once told me the world is gonna roll me..."};


        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }

}
