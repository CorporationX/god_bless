package bjs2_33391;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> messages = new ArrayList<>() {{
            add(new Email("Дискорд забанили", "Как жить?", true));
            add(new Email("Былые времена...", "А ведь раньше все было так хорошо...", true));
            add(new Email("Спам", "Скам", false));
        }};

        Predicate<Email> unimportantMessage = (message) -> !message.isImportant();
        Consumer<Email> printMessage = (message) -> System.out.println("Обработано письмо: " + message.getSubject());
        Function<Email, String> toLowerCase = (message) -> message.getBody().toLowerCase();

        emailProcessor.processEmail(messages, unimportantMessage, toLowerCase, printMessage);

        messages.forEach(message -> System.out.println("Тема: " + message.getSubject() +
                ", Тело письма: " + message.getBody()));
    }
}
