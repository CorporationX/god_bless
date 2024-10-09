package bjs2_33391;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmail(List<Email> messages, Predicate<Email> filter,
                             Function<Email, String> transformBody, Consumer<Email> process) {
        // используем итератор, ибо при удалении через индекс все элементы справа смещаются на один,
        // что делает обход неконсистентным + есть риски выйти за пределы списка
        Iterator<Email> iterator = messages.iterator();

        while (iterator.hasNext()) {
            Email message = iterator.next();

            if (filter.test(message)) {
                iterator.remove();
            }
            message.setBody(transformBody.apply(message));
            process.accept(message);
        }
    }
}
