package faang.school.godbless.email;

import faang.school.godbless.Email;
import faang.school.godbless.EmailProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class emailProcessorTest {
    EmailProcessor emailProcessor;
    @BeforeEach
    public void setUp() {
        emailProcessor = new EmailProcessor();
    }


    @Test
    public void testProcessEmails() {

        // �������� ������ �������� �����
        List<Email> emails = Arrays.asList(
                new Email("������ 1", "����� ������ 1", false),
                new Email("������ 2", "����� ������ 2", true),
                new Email("����", "����� �����", false)
        );

        // �������� ��������, ������������ � ����������������
        Predicate<Email> importantFilter = Email::isImportant;
        Predicate<Email> spamFilter = email -> email.getSubject().equalsIgnoreCase("����");
        Consumer<Email> printEmail = email -> System.out.println("���������� ������: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        // ��������� ����� � �������� �� ��������
        List<Email> filteredEmails = new ArrayList<>();
        Consumer<Email> collectFilteredEmails = filteredEmails::add;

        emailProcessor.processEmails(emails, importantFilter, collectFilteredEmails, toUpperCase);

        assertEquals(1, filteredEmails.size());
        assertEquals("����� ������ 2", filteredEmails.get(0).getBody());

        // ��������� ����� � �������� �� ����
        filteredEmails.clear();

        emailProcessor.processEmails(emails, spamFilter, collectFilteredEmails, toUpperCase);

        assertEquals(1, filteredEmails.size());
        assertEquals("����� �����", filteredEmails.get(0).getBody());
    }
}
