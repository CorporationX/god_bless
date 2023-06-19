package faang.school.godbless.secondSprint.FilterSpam;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter bookmakerFilter = message -> message.contains("1xbet") || message.contains("parimatch");
        MessageFilter momFilter = message -> message.contains("сынок") || message.contains("сынуля");
        List<MessageFilter> filters = List.of(bookmakerFilter, momFilter);

        List<String> messages = List.of(
                "сынок, мы не видились 5 лет, позвони мне",
                "Бонус на пополнение 50%, только сегодня на 1xbet",
                "Ладно, сырная шаверма, так сырная шаверма.");

        messages.stream().filter(message -> messageProcessor.processMessage(message, filters))
                .forEach(message -> System.out.println("Cообщение: '" + message + "' прошло все фильтры"));
    }
}
