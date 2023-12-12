package faang.school.godbless.filter_spam;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String... args){
        MessageProcessor messageProcessor = new MessageProcessor();
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length()<20;
        MessageFilter debtFilter = message -> !message.toLowerCase().contains("займешь");

        List<MessageFilter> filters = Arrays.asList(spamFilter,lengthFilter,debtFilter);
        String[] messages = {"Привет!", "It is spam!", "Займешь 1к до зп", "Длинное сообщение без спама и займов"};
// Интересно, но если написать "спам" по-русски и лямбде и в массиве, то будет его пропускать. ДА и вообще, дебаг русский
// язык не воспринимает у меня
        for(String message : messages){
            boolean isFiltered=messageProcessor.processMessage(message,filters);
            System.out.println("Message: "+message+" Skipped: "+isFiltered);
        }
    }
}
