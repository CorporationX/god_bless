package faang.school.godbless.sprint_3.task_48712;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    public static final int NUMBER_OF_LETTERS = 1000;

    private static final List<String> EMAILS = createEmails();

    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            if (i >= EMAILS.size()) {
                return;
            }
            System.out.println(EMAILS.get(i) + " отправлено");
        }
    }

    private static List<String> createEmails() {
        List<String> emails = new ArrayList<>();
        for (int i = 1; i <= NUMBER_OF_LETTERS; i++) {
            emails.add("Письмо №" + i);
        }
        return emails;
    }
}
