package faang.school.godbless.filterTheSpam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor processor = new MessageProcessor();

        List<MessageFilter> filters = Arrays.asList(
                str -> str.toLowerCase().contains("spam"),
                string -> string.toLowerCase().contains("bulium")
        );

        List<String> strings = Arrays.asList(
                "it is spam", "it is bulium", "it is nice"
        );

        for (String s : strings) {
            System.out.println("Сообщение: " + s + " | Пропущено: " + processor.processMessage(s, filters));
        }
    }
}
