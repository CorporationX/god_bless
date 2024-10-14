package you_work_for_microsoft;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class MailSenderTest {
    @Test
    void testSendAllEmails() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        SenderRunnable mockRunnable = mock(SenderRunnable.class);
        List<Thread> threads = List.of(new Thread(mockRunnable), new Thread(mockRunnable));

        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
        verify(mockRunnable, times(threads.size())).run();

        System.setOut(originalOut);
    }
}