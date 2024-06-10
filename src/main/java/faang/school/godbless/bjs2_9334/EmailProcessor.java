package faang.school.godbless.bjs2_9334;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

  public void processEmails(List<Email> emails,
      Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
    final List<String> filteredEmails = emails.stream()
        .filter(predicate)
        .peek(consumer)
        .map(function)
        .toList();

    filteredEmails.forEach(System.out::println);

  }

}
