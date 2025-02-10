package school.faang.gmail_rich_filters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmailProcessor {
    // Predicate для фильтрации писем
    // Consumer для их обработки
    // Function для преобразования

    public static List<String> processEmails(List<Email> listInputEmails, Predicate<Email> filterCondition,
                                     Function<Email, String> transform, Consumer<Email> processing) {


        var filteredList = listInputEmails.stream().filter(filterCondition).toList();

        listInputEmails.forEach(processing);

        return filteredList.stream().map(transform).collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {

        var listEmails = Arrays.asList(
                new Email("About working", "Email text 1", false),
                new Email("About studying", "Email text 2", true),
                new Email("Annoying advertising", "Spam", false));

        Predicate<Email> isSpam = email -> !email.getSubject().equals("Annoying advertising")
                && email.isImportant();

        Function<Email, String> editedEmail = email -> {
            String editedText = new StringBuilder("Subject: " + email.getSubject()).append("\n")
                    .append("Main text: " + email.getBody()).append("\n")
                    .append("Importance: " + email.isImportant()).append("\n").toString();

            return editedText;
        };

        Consumer<Email> forReading = email -> email.setSubject("Email for reading: " + email.getSubject() + "\n");

        var resultList = processEmails(listEmails, isSpam, editedEmail, forReading);
    }
}
