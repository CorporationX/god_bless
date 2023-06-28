package faang.school.godbless.sprint_3.task_6;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> incomingMail, Predicate<Email> filter, Consumer<Email> treatment, Function<Email, String> transformation) {
        for (Email email : incomingMail) {
            if (filter.test(email)) {
                treatment.accept(email);
                transformation.apply(email);
            }
        }
    }
}
   /* Создайте класс Email с полями subject, body и isImportant;

    Создайте класс EmailProcessor с методом processEmails;

    Метод processEmails должен принимать список входящих писем,
    Predicate для фильтрации,
    Consumer для обработки и Function для преобразования писем;

    Создайте несколько лямбда-выражений для Predicate, Consumer, и Function;

    Протестируйте вашу систему, обрабатывая несколько входящих писем с разными настройками фильтрации и обработки.*/
