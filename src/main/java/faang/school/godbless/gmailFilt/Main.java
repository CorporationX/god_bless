package faang.school.godbless.gmailFilt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

// �������� ������ �������� �����
        List<Email> emails = new ArrayList<>(Arrays.asList(
                new Email("������ 1", "����� ������ 1", false),
                new Email("������ 2", "����� ������ 2", true),
                new Email("����", "����� �����", false)
        ));

       // �������� ��������, ������������ � ����������������
        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("���������� ������: " + email.getSubject());
        Function<Email, Email> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email;
        };

// ��������� �����
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}

