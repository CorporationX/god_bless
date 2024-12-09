package school.faang.task_45764;

import java.util.function.Predicate;

public class FilterEmail {
    public Predicate<Email> filter(boolean isImportant) {
        return f -> f.isImportant() == isImportant;
    }
}
