package school.faang.sprint_2.gmail_rich_filters;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> emailFilter,
                              Function<Email, String> emailEditor,
                              Consumer<Email> emailHandler) {
        emails.stream()
                .filter(emailFilter)
                .peek(emailHandler)
                .map(emailEditor)
                .forEach(log::info);
    }
}
