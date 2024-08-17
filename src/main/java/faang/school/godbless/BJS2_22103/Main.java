package faang.school.godbless.BJS2_22103;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageFilter filter1 = message -> Arrays.stream(message.split(" "))
                .noneMatch(word -> word.equals("faang") || word.equals("godbless"));
        MessageFilter filter2 = message -> message.trim().length() == message.length();
        MessageFilter filter3 = message -> message.chars().noneMatch(Character::isDigit);

        String message1 = "hello faang", message2 = "  hello trim", message3 = "hello 123";

        System.out.println(message1);
        System.out.println(message2);
        System.out.println(message3);

        MessageProcessor.processMessage(message1, List.of(filter1, filter2, filter3));
        MessageProcessor.processMessage(message2, List.of(filter1, filter2, filter3));
        MessageProcessor.processMessage(message3, List.of(filter1, filter2, filter3));
        System.out.println();

        MessageProcessor.processMessage(message1, List.of(filter2, filter3));
        MessageProcessor.processMessage(message2, List.of(filter1, filter3));
        MessageProcessor.processMessage(message3, List.of(filter1, filter2));
    }
}
