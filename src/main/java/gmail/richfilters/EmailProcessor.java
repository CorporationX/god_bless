package gmail.richfilters;


import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
Создайте класс EmailProcessor с методом processEmails.

Метод processEmails должен:
принимать список входящих писем;
фильтровать их с помощью Predicate<Email>
преобразовывать тело письма с помощью Function<Email, String>.
обрабатывать каждое письмо с помощью Consumer<Email>

Создайте несколько лямбда-выражений для Predicate, Consumer, и Function,
 чтобы настроить фильтрацию и обработку писем по вашему выбору.

* */
public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> processor,
                              Function<Email, String> transformer) {

        if (emails == null || emails.isEmpty()) {
            throw new IllegalArgumentException("Список писем не может быть пустым");
        }
        if (filter == null || processor == null || transformer == null) {
            throw new IllegalArgumentException("Фильтр, процессор преобразователь не могут быть пустыми");
        }

        for (Email email : emails) {
            if (filter.test(email)) {
                String updatedBody = transformer.apply(email);
                email.setBody(updatedBody);

                processor.accept(email);
            }
        }
    }

}
