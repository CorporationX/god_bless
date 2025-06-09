package school.faang.filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmailProcessor {
 public List<String> processEmails (List<Email> emails, Predicate<Email> filter, Function<Email, String> reform, Consumer<Email> process) {
  return emails.stream()
          .filter(filter)
          .peek(process)
          .map(reform)
          .collect(Collectors.toList());
 }
}
