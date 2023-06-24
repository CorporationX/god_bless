package sprint3.lambda.gmail;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    private static final EmailProcessor EMAIL_PROCESSOR = new EmailProcessor();

    public static void main(String[] args) {
        List<Email> emails = getEmails();

        Predicate<Email> importantFilter = email -> !email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("���������� ������: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        EMAIL_PROCESSOR.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }

    private static List<Email> getEmails() {
        return Arrays.asList(
                new Email("Jira: ���� ���...", "...�����������", true),
                new Email("�����", "���� �����", true),
                new Email("������", "�� ��� ��� � ��������?", false),
                new Email("�������", "����� ������� ���������...", false)
        );
    }
}
