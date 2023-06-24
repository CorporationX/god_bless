package faang.school.godbless.gmail;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        for (Email email : emails) {
            predicate.test(email);
            consumer.accept(email);
            function.apply(email);
        }
    }

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        // �������� ������ �������� �����
        List<Email> emails = Arrays.asList(
                new Email("������ 1", "����� ������ 1", false),
                new Email("������ 2", "����� ������ 2", true),
                new Email("����", "����� �����", false)
        );

        // �������� ��������, ������������ � ����������������
        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("���������� ������: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        // ��������� �����
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}
