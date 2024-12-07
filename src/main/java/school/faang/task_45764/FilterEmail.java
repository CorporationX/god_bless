package school.faang.task_45764;

import java.util.function.Predicate;

public class FilterEmail {
    public Predicate<Email> filter(boolean isImportant) {
        Predicate<Email> filter = f -> f.isImportant() == isImportant;
        return filter;
    }
}
