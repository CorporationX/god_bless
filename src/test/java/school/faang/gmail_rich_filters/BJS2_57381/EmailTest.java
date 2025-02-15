package school.faang.gmail_rich_filters.BJS2_57381;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    private Email email;

    @BeforeEach
    void setUp() {
        email = new Email("Письмо 1", "Текст письма 1", false);
    }

    @Test
    void getSubject() {
        assertEquals("Письмо 1", email.getSubject());
    }

    @Test
    void getBody() {
        assertEquals("Текст письма 1", email.getBody());
    }

    @Test
    void isImportant() {
        assertFalse(email.isImportant());
    }

    @Test
    void setSubject() {
        email.setSubject("Письмо 2");

        assertEquals("Письмо 2", email.getSubject());
    }

    @Test
    void setBody() {
        email.setBody("Текст письма 2");

        assertEquals("Текст письма 2", email.getBody());
    }

    @Test
    void setImportant() {
        email.setImportant(true);
        assertTrue(email.isImportant());
    }
}