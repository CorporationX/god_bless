package sprint3task6;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//настраивать фильтры для обработки входящих писем.
public class EmailProcessor {
    //Predicate для фильтрации писем, Consumer для обработки писем и
    // Function для преобразования писем.
    //Predicate <> Consumer  Function

    public void processEmails (List<Email> emails, Predicate<Email> filter,
                               Consumer<Email> handling,
                               Function<Email, T> converting){


    }

}
