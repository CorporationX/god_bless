package school.faang.bjs_87778;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageFilter failure = (message -> message.contains("неудача"));
        MessageFilter ability = (message -> message.contains("не сможешь"));
        MessageFilter begin = (message -> message.contains("не надо начинать"));

        List<MessageFilter> filters = List.of(failure, ability, begin);

        String message1 = "Тебя ждет неудача!";
        String message2 = "Ты не сможешь!";
        String message3 = "Ты победишь!";

        for (String message : List.of(message1, message2, message3)) {
            if (! MessageProcessor.processMessage(message, filters)) {
                System.out.println(message);
            }
        }
    }
}
