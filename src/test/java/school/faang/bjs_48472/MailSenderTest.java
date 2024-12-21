package school.faang.bjs_48472;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MailSenderTest {

    @Test
    void sendMail() {
        MailSender mailSender = new MailSender(5, 1000, 200);
        int actual = mailSender.sendMail();
        int expected = 1000;
        assertEquals(expected, actual);
    }
}