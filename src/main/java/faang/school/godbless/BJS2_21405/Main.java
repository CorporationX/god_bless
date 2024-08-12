package faang.school.godbless.BJS2_21405;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<Character, String> numberByWordNumber = Map.of(
                '1', "_one_",
                '2', "_two_",
                '3', "_three_",
                '4', "_four_",
                '5', "_five_",
                '6', "_six_",
                '7', "_seven_",
                '8', "_eight_",
                '9', "_nine_",
                '0', "_zero_"
        );
        List<Email> emails = new ArrayList<>(List.of(
                new Email("Java", "Hello world!", false),
                new Email("discord ", "+999 уведомлений в канале Help", false),
                new Email(" jIRa", "Код не прошел ревью!", true),
                new Email("Google calendar", "в 19:00 сессия", true)
        ));

        Predicate<Boolean> isImportant = (isImp) -> isImp || System.currentTimeMillis() % 2 == 0;

        Consumer<Email> processBody = (email) -> {
            String newBody = email.getBody().chars()
                    .mapToObj(ch -> (char) ch)
                    .map((ch) -> numberByWordNumber.getOrDefault(ch, Character.toString(ch)))
                    .collect(Collectors.joining());
            email.setBody(newBody);
        };

        Function<String, String> validateSubject = (subject) -> {
            subject = subject.trim();
            char firstUppercaseLetter = Character.toUpperCase(subject.charAt(0));
            return firstUppercaseLetter + subject.substring(1).toLowerCase();
        };

        System.out.println(emails);
        System.out.println();
        EmailProcessor.processEmails(emails, isImportant, processBody, validateSubject);
        System.out.println(emails);
    }
}
