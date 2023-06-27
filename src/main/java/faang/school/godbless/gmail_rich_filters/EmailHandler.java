package faang.school.godbless.gmail_rich_filters;

import lombok.Builder;
import lombok.Data;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
@Builder
public class EmailHandler {

    private Predicate<Email> filter;
    private Consumer<Email> processor;
    private Function<Email, String> converter;
}
